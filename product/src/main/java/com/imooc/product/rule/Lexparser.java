//package com.imooc.product.rule;
//
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Lexparser {
//    private PatternTree patternTree;
//    private SlotTree slotTree;
//
//    public Lexparser() {
//        patternTree = new PatternTree();
//        slotTree = new SlotTree();
//    }
//
//    public Lexparser(String patternFilePath, String slotFilePath) {
//        patternTree = new PatternTree();
//        slotTree = new SlotTree();
//        load(patternFilePath, slotFilePath);
//    }
//
//    private void load(String patternFilePath, String slotFilePath) {
//        InputStream is = null;
//        InputStreamReader inputReader = null;
//        BufferedReader bf = null;
//        try {
//            Path path = Paths.get(patternFilePath);
//            if (path.toFile().exists()) {
//                is = Files.newInputStream(path);
//            } else {
//                is = Lexparser.class.getResourceAsStream(patternFilePath);
//                if (is == null) {
//                    is = Lexparser.class.getResourceAsStream("/static/rule_engine/pattern");
//                }
//            }
//            inputReader = new InputStreamReader(is);
//            bf = new BufferedReader(inputReader);
//
//            String line = "";
//            Pattern re = Pattern.compile("\\[@(\\w+)\\]");
//            String intentName = "";
//            while ((line = bf.readLine()) != null) {
//                line = line.trim();
//                Matcher matcher = re.matcher(line);
//                if (matcher.find()) {
//                    intentName = matcher.group(1);
//                } else {
//                    List<String> normalText = patternTree.addTree(line, intentName);
//                    if (normalText != null) {
//                        for (String t : normalText) {
//                            slotTree.addTree(t, SlotType.NORMAL_TEXT);
//                        }
//                    }
//                }
//            }
//            bf.close();
//        } catch (IOException e) {
////            myself log
//            e.printStackTrace();
//        } finally {
//            try {
//                if (bf != null) {
//                    bf.close();
//                }
//                if (inputReader != null) {
//                    inputReader.close();
//                }
//                if (is != null) {
//                    is.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            Path path = Paths.get(slotFilePath);
//            if (path.toFile().exists()) {
//                is = Files.newInputStream(path);
//            } else {
//                is = Lexparser.class.getResourceAsStream(slotFilePath);
//                if (is == null) {
//                    is = Lexparser.class.getResourceAsStream("/static/rule_engine/slots");
//                }
//            }
//            inputReader = new InputStreamReader(is);
//            bf = new BufferedReader(inputReader);
//            String line = "";
//            String slotName = "";
//            while ((line = bf.readLine()) != null) {
//                line = line.trim();
//                int slotIndex = patternTree.getSlotIndex(line);
//                if (slotIndex > 0) {
//                    slotName = line.substring(0, slotIndex);
//                } else {
//                    slotTree.addTree(line, slotName);
//                }
//            }
//            bf.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (bf != null) {
//                    bf.close();
//                }
//                if (inputReader != null) {
//                    inputReader.close();
//                }
//                if (is != null) {
//                    is.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private String matchPattern(LexparserNode obj) {
//        PatternTree ptree = obj.patternTree;
//        String text = obj.nextWord;
//        if (text != null && text.length() > 0) {
//            return "";
//        }
//        if (Utils.isEmpty(ptree.root.intent)) {
//            return "";
//        }
//        return ptree.root.intent;
//    }
//
//    public List<LexParserResult> parse(String text) {
//        List<LexParserResult> resCandidates = new ArrayList<>();
//        if (Utils.isEmpty(text)) {
//            return resCandidates;
//        }
//        LexparserNode root = new LexparserNode();
//        root.nextWord = text;
//        root.patternTree = patternTree;
//        List<LexparserNode> candidates = new ArrayList<>();
//        candidates.add(root);
//        List<LexparserNode> results = new ArrayList<>();
//        while (!candidates.isEmpty()) {
//            LexparserNode cand = candidates.get(0);
//            text = cand.nextWord;
//            int tlen = text.length();
//            PatternTree ptree = cand.patternTree;
//            if (ptree.root.children.containsKey(PatternType.PATTERN_WILDTREE)) {
//                PatternNode node = ptree.root.children.get(PatternType.PATTERN_WILDTREE);
//                for (Map.Entry<String, PatternNode> entry : node.children.entrySet()) {
//                    PatternNode wtree = entry.getValue();
//                    int lower = wtree.lower;
//                    int upper = wtree.upper;
//                    while (lower <= upper && lower <= tlen) {
//                        LexparserNode obj = new LexparserNode();
//                        obj.currentWord = text.substring(0, lower);
//                        obj.slot = SlotType.WILD_WORD;
//                        obj.nextWord = text.substring(lower);
//                        obj.preNode = candidates.get(0);
//                        obj.patternTree = new PatternTree(wtree);
//                        obj.intentName = wtree.intent;
//                        if (obj.nextWord.length() > 0 || Utils.isEmpty(wtree.intent)) {
//                            candidates.add(obj);
//                        } else {
//                            results.add(obj);
//                        }
//                        lower++;
//                    }
//                }
//            }
//            handleQuestionMarkNode(text, ptree, candidates, results);
//            searchNumberNode(text, ptree, candidates, results);
//            doOneStepSearch(text, ptree, candidates, results);
//            candidates.remove(0);
//        }
//        for (LexparserNode result : results) {
//            LexParserResult res = new LexParserResult();
//            res.setIntent(result.intentName);
//            List<SlotType> slots = new ArrayList<>();
//            LexparserNode r = result;
//            while (r.preNode != null) {
//                if (!Utils.isEmpty(r.slot)) {
//                    slots.add(0, new SlotType(r.slot, r.currentWord));
//                }
//                r = r.preNode;
//            }
//            res.setSlots(slots);
//            res.printResult();
//            resCandidates.add(res);
//        }
//        return resCandidates;
//    }
////todo
//    private void doOneStepSearch(String text, PatternTree ptree, List<LexparserNode> candidates, List<LexparserNode> results) {
//    }
////TODO
//    private void searchNumberNode(String text, PatternTree ptree, List<LexparserNode> candidates, List<LexparserNode> results) {
//    }
//
//    private void handleQuestionMarkNode(String text, PatternTree ptree, List<LexparserNode> candidates, List<LexparserNode> results) {
//        if (ptree.root.children.containsKey(PatternType.PATTERN_QUESTION_MARK)) {
//            PatternNode node = ptree.root.children.get(PatternType.PATTERN_QUESTION_MARK);
//            for (Map.Entry<String, PatternNode> entry : node.children.entrySet()) {
//                PatternNode qtree = entry.getValue();
//                String rawText = qtree.text.substring(3, qtree.text.length() - 1);
//                if (text.startsWith(rawText)) {
//                    LexparserNode obj = new LexparserNode();
//                    obj.currentWord = rawText;
//                    obj.slot = PatternType.PATTERN_QUESTION_MARK;
//                    obj.nextWord = text.substring(rawText.length());
//                    obj.preNode = candidates.get(0);
//                    obj.patternTree = new PatternTree(qtree);
//                    obj.intentName = qtree.intent;
//                    if (obj.nextWord.length() > 0 || Utils.isEmpty(qtree.intent)) {
//                        candidates.add(obj);
//                    } else {
//                        results.add(obj);
//                    }
//                }
//            }
//        }
//    }
//}

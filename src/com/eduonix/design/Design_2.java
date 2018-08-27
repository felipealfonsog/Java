package com.eduonix.design;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class Design_2 {


        private static final int LENGTH = 80;
        private int[] startPoints;
        //memoization
        private HashMap<String, Integer> unJustifiedLineCount = new HashMap<String, Integer>();
        private HashMap<Integer, Integer> justifiedCountBag;

        public String justifyDynamic(String input, int max){

            unJustifiedLineCount = new HashMap<String, Integer>();
            justifiedCountBag = new HashMap<Integer, Integer>();

            String[] text=input.split(" ");
            startPoints = new int[text.length];

            justifyRecursive(text, 0);

            StringBuilder sb=new StringBuilder();
            int k=0;
            int i= startPoints[k];
            while(i < text.length){
                for(int j= k; j< i; j++){
                    sb.append(text[j]+" ");
                }
                sb.deleteCharAt(sb.length()-1).append("\n");
                k=i;
                i= startPoints[i];
            }
            // last line
            for(int j=k;j<i;j++){
                sb.append(text[j]+" ");
            }
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }

        private int justifyRecursive(String[] text, int start){
            if(start==text.length){
                return 0;
            }
            if(justifiedCountBag.containsKey(start)){
                return justifiedCountBag.get(start);
            }
            int unjustifiedMetric= Integer.MAX_VALUE;
            int index=-1;
            for (int i=start;i< text.length; i++){
                int b = countUnjustified(text, start, i, LENGTH)+justifyRecursive(text, i+1);
                if (b < 0){
                    b = Integer.MAX_VALUE;
                }
                if(b < unjustifiedMetric){
                    unjustifiedMetric = b;
                    index=i;
                }
            }
            startPoints[start]=index+1;
            justifiedCountBag.put(start, unjustifiedMetric);
            return unjustifiedMetric;
        }

        public String justifyGreedy(String text, final int max){
            StringBuilder sb=new StringBuilder();
            while(text.length() > max){
                int i=text.substring(0, max+1).lastIndexOf(" ");
                sb.append(text.substring(0,i)+"\n");
                text=text.substring(i+1);
            }
            sb.append(text);
            return sb.toString();
        }


        private static int getUnjustifiedMetric(String text, int maxWidth){
            String[] lines=text.split("\n");
            int unjustifiedCount=0;
            for(String line:lines){
                if (line.length()> maxWidth){
                    return Integer.MAX_VALUE;
                }
                unjustifiedCount+=(int)Math.pow(maxWidth-line.length(), 3);
            }
            return unjustifiedCount;
        }
        private int countUnjustified(String[] text, int wi, int wj, int maxWidth){
            if(unJustifiedLineCount.containsKey(wi+","+wj)){
                return unJustifiedLineCount.get(wi+","+wj);
            }
            // count the length of the line
            int length=length(text, wi, wj);
            if(length > maxWidth){
                unJustifiedLineCount.put(wi+","+wj, Integer.MAX_VALUE);
                return Integer.MAX_VALUE;
            }
            unJustifiedLineCount.put(wi+","+wj, (int) Math.pow(maxWidth-length,3));
            return (int) Math.pow(maxWidth-length,3);
        }
        //calculate total length from text[wi] to text[wj];
        private static int length(String[] text, int wi, int wj){
            int length=wj-wi;
            for (int i=wi;i<=wj;i++){
                length+=text[i].length();
            }
            return length;
        }

        public static void main(String[] args) throws IOException, URISyntaxException {
            Design_2 m=new Design_2();
            String content = new String(Files.readAllBytes(
                    Paths.get(Design_2.class.getResource("spear.txt").toURI())));
            String justify= m.justifyDynamic(content, LENGTH);
            System.out.println(justify);
            System.out.println("=== INEFFICIENCY FOR DYNAMIC : "
                    + getUnjustifiedMetric(justify, LENGTH));
            String greedy=m.justifyGreedy (content, LENGTH);
            System.out.println(greedy);
            System.out.println("=== INEFFICIENCY FOR GREEDY: "
                    + getUnjustifiedMetric(greedy, LENGTH));

        }
    }


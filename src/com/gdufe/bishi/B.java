package com.gdufe.bishi;

import java.util.Scanner;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2019/3/30 19:55
 */
public class B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String originTree = scan.nextLine();
            String[] trees = originTree.split(",");
            int length = trees.length;
            int height = 0;
            int h = 1;
            while(h<length + 1) {
                h *= 2;
                height ++;
            }
            if((int)Math.pow(2, height)-1 != length) {
                System.out.println("False");
                continue;
            }
            Node[] nodes = new Node[length];
            for(int i=0; i<length; i++) {
                int min = Integer.MIN_VALUE;
                int max = Integer.MAX_VALUE;
                if(!trees[i].equals("None")) {
                    min = Integer.parseInt(trees[i]);
                    max = min;
                }
                Node node = new Node(trees[i], min, max);
                nodes[i] = node;
            }
            System.out.println(isTwoSearchTree(nodes, height)?"True":"False");
        }
    }

    public static boolean isTwoSearchTree(Node[] nodes, int height) {
        boolean res = true;
        for(int i=height-2; i>=0; i--) {
            int start = (int) (Math.pow(2, i) - 1);
            int end = (int) (start + Math.pow(2, i));
            boolean flag = true;
            for(int j=start; j<end; j++) {
                Node leftNode = nodes[j * 2 + 1];
                Node rightNode = nodes[j * 2 + 2];
                int leftMax = leftNode.getMax();
                int rightMin = rightNode.getMin();
                boolean left = false;
                boolean right = false;
                int value = 0;
                Node node = nodes[j];
                if(leftNode.getValue().equals("None")) {
                    if(rightNode.getValue().equals("None")) {
                        left = true;
                        right = true;
                    } else {
                        if(!node.getValue().equals("None")) {
                            value = Integer.parseInt(node.getValue());
                            if(value <= rightMin) {
                                left = true;
                                right = true;
                                node.setMax(rightMin);
                            }
                        }
                    }
                } else {
                    if(!rightNode.getValue().equals("None")) {
                        if(!node.getValue().equals("None")) {
                            value = Integer.parseInt(node.getValue());
                            if(value <= rightMin && value >= leftMax) {
                                left = true;
                                right = true;
                                node.setMax(rightMin);
                                node.setMin(leftMax);
                            }
                        }
                    } else {
                        if(!node.getValue().equals("None")) {
                            value = Integer.parseInt(node.getValue());
                            if(value >= leftMax) {
                                left = true;
                                right = true;
                                node.setMin(leftMax);
                            }
                        }
                    }
                }
                if(!(left && right)) {
                    flag = false;
                    res = false;
                    break;
                }
            }
            if(!flag) {
                break;
            }
        }
        return res;
    }
}




/**
 * 节点
 */
class Node {
    /**
     * 节点值
     */
    private String value;
    /**
     * 最小值
     */
    private int min;
    /**
     * 最大值
     */
    private int max;

    public Node(String value, int min, int max) {
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}

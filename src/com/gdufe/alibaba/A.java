package com.gdufe.alibaba;

import java.util.*;

/**
 * @Author: laichengfeng
 * @Description:
 * @Date: 2018/8/11 17:09
 */
public class A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            int n = scan.nextInt();
            List<Point> points = new ArrayList<>(n);
            for(int i=0; i<n; i++) {
                String input = scan.nextLine();
                points.add(new Point(input));
            }
            Comparator<Point> comparator = new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.x < o2.x) {
                        return 1;
                    }
                    if(o1.x > o2.x) {
                        return -1;
                    }
                    if(o1.x == o2.x) {
                        if(o1.y < o2.y) {
                            return 1;
                        }
                        if(o1.y > o2.y) {
                            return -1;
                        }
                    }
                    return 0;
                }
            };
            Collections.sort(points, comparator);
            int result = 0;
            for(int i=0; i<n; i++) {
                // 先走横坐标最近的?或是纵坐标?

            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(String input) {
            this.x = Integer.valueOf(input.split(",")[0]);
            this.y = Integer.valueOf(input.split(",")[1]);
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}

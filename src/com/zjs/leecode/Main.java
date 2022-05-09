package com.zjs.leecode;

import java.util.*;

/**
 * @author zjs
 * @version 1.0
 * @data 2022/4/17 16:13
 **/
public class Main {
    static class Node{
        String name;
        int points;
        int goals_for;
        int goals_against;

        public Node(String name, int points, int goals_for, int goals_against) {
            this.name = name;
            this.points = points;
            this.goals_for = goals_for;
            this.goals_against = goals_against;
        }

        public String getName() {
            return name;
        }

        public int getPoints() {
            return points;
        }

        public int getGoals_for() {
            return goals_for;
        }

        public int getGoals_against() {
            return goals_against;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public void setGoals_for(int goals_for) {
            this.goals_for = goals_for;
        }

        public void setGoals_against(int goals_against) {
            this.goals_against = goals_against;
        }

        public String toString(){
            return this.getName() + " " + this.getPoints() + " " + this.getGoals_for() + " " + this.getGoals_against();
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner sca = new Scanner(System.in);
        int T = Integer.parseInt(sca.nextLine());
        for(int j = 0; j < T; j++){
            Node[] teams = new Node[6];
            for(int i = 0; i < 9; i++){
                String tmp = sca.nextLine();
                if(i < 6){
                    String[] infos = tmp.split(" ");
                    teams[i] = new Node(infos[0], Integer.parseInt(infos[1]), Integer.parseInt(infos[2]), Integer.parseInt(infos[3]));
                    map.put(infos[0], i);
                }else{
                    String infos[] = tmp.split(" ");
                    if(Integer.parseInt(infos[2]) > Integer.parseInt(infos[3])){
                        teams[map.get(infos[0])].setPoints(teams[map.get(infos[0])].getPoints() + 3);
                        teams[map.get(infos[0])].setGoals_for(teams[map.get(infos[0])].getGoals_for() + Integer.parseInt(infos[2]));
                        teams[map.get(infos[0])].setGoals_against(teams[map.get(infos[0])].getGoals_against() + Integer.parseInt(infos[3]));
                        teams[map.get(infos[1])].setGoals_for(teams[map.get(infos[1])].getGoals_for() + Integer.parseInt(infos[3]));
                        teams[map.get(infos[1])].setGoals_against(teams[map.get(infos[1])].getGoals_against() + Integer.parseInt(infos[2]));

                    }else if(Integer.parseInt(infos[2]) == Integer.parseInt(infos[3])){
                        teams[map.get(infos[0])].setPoints(teams[map.get(infos[0])].getPoints() + 1);
                        teams[map.get(infos[1])].setPoints(teams[map.get(infos[1])].getPoints() + 1);
                        teams[map.get(infos[0])].setGoals_for(teams[map.get(infos[0])].getGoals_for() + Integer.parseInt(infos[2]));
                        teams[map.get(infos[0])].setGoals_against(teams[map.get(infos[0])].getGoals_against() + Integer.parseInt(infos[3]));
                        teams[map.get(infos[1])].setGoals_for(teams[map.get(infos[1])].getGoals_for() + Integer.parseInt(infos[3]));
                        teams[map.get(infos[1])].setGoals_against(teams[map.get(infos[1])].getGoals_against() + Integer.parseInt(infos[2]));

                    }else{
                        teams[map.get(infos[1])].setPoints(teams[map.get(infos[1])].getPoints() + 3);
                        teams[map.get(infos[1])].setGoals_for(teams[map.get(infos[1])].getGoals_for() + Integer.parseInt(infos[3]));
                        teams[map.get(infos[1])].setGoals_against(teams[map.get(infos[1])].getGoals_against() + Integer.parseInt(infos[2]));
                        teams[map.get(infos[0])].setGoals_for(teams[map.get(infos[0])].getGoals_for() + Integer.parseInt(infos[2]));
                        teams[map.get(infos[0])].setGoals_against(teams[map.get(infos[0])].getGoals_against() + Integer.parseInt(infos[3]));
                    }
                }
            }
            Arrays.sort(teams, new Comparator<Node>() {

                @Override
                public int compare(Node a, Node b) {
                    if (a.getPoints() > b.getPoints()) {
                        return -1;
                    } else if (a.getPoints() < b.getPoints()) {
                        return 1;
                    } else {
                        if ((a.getGoals_for() - a.getGoals_against()) > (b.getGoals_for() - b.getGoals_against())) {
                            return -1;
                        } else if ((a.getGoals_for() - a.getGoals_against()) < (b.getGoals_for() - b.getGoals_against())) {
                            return 1;
                        } else {
                            if (a.getGoals_for() > b.getGoals_for()) {
                                return -1;
                            } else if (a.getGoals_for() < b.getGoals_for()) {
                                return 1;
                            } else {
                                return a.getName().compareTo(b.getName());
                            }
                        }
                    }
                }
            });
            for(Node t : teams){
                System.out.println(t);
            }
            System.out.println("END");
        }

    }
}
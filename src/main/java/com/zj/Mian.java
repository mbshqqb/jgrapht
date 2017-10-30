package com.zj;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.alg.scoring.PageRank;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Mian {
    public static void main(String[] args) {
        IdentityGraphLoader identityGraphLoader=new IdentityGraphLoader();
        Graph<Identity,DefaultEdge>graph=identityGraphLoader.getIdentityGraph("test.csv");
        PageRank<Identity,DefaultEdge>pageRank=new PageRank<Identity,DefaultEdge>(graph,0.85,100,1.0e-6);
        LinkedHashMap<Identity, Double> sorted =pageRank.getScores().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10000).collect(Collectors.toMap((Map.Entry k_v)->(Identity)k_v.getKey(), (Map.Entry k_v)->(Double)k_v.getValue(),(e1, e2) -> e1, LinkedHashMap::new));;//参见：https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values-java
//        sorted.entrySet().stream().forEach((k_v)->System.out.println(k_v.getKey().getUid()+"---->"+k_v.getValue()));

        System.out.println("-------------------------------------------------------------");
        Graph<Identity,DefaultEdge>graph2=new SimpleDirectedGraph<Identity, DefaultEdge>(DefaultEdge.class);
        sorted.entrySet().stream().forEach(graph2.add());
        PageRank<Identity,DefaultEdge>pageRank2=new PageRank<Identity,DefaultEdge>(graph,0.85,100,1.0e-6);
        LinkedHashMap<Identity, Double> sorted2 =pageRank.getScores().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(100).collect(Collectors.toMap((Map.Entry k_v)->(Identity)k_v.getKey(), (Map.Entry k_v)->(Double)k_v.getValue(),(e1, e2) -> e1, LinkedHashMap::new));;//参见：https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values-java
        sorted.entrySet().stream().forEach((k_v)->System.out.println(k_v.getKey().getUid()+"---->"+k_v.getValue()));


    }
}
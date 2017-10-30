package com.zj;

import au.com.bytecode.opencsv.CSVReader;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentityGraphLoader {
    public Graph<Identity, DefaultEdge> getIdentityGraph(String file){
        CSVReader csvReader=new CSVReader(new InputStreamReader(IdentityGraphLoader.class.getResourceAsStream("/"+file)));
        Graph<Identity,DefaultEdge> graph=new SimpleDirectedGraph<Identity, DefaultEdge>(DefaultEdge.class);
        String[] line;
        try {
            while((line=csvReader.readNext())!=null){
                Identity v1=new Identity(line[0]);
                Identity v2=new Identity(line[1]);
                if(!graph.containsVertex(v1)){
                    graph.addVertex(v1);
                }
                if(!graph.containsVertex(v2)){
                    graph.addVertex(v2);
                }
                if(!v1.equals(v2)){
                    graph.addEdge(v1,v2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }
}

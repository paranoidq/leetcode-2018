package me.leetcode3;

import me.UndirectedGraphNode;

import java.util.*;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P133 {

    // 错误，没有考虑到重复访问同一个节点的情况
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);

        UndirectedGraphNode newCurrent = new UndirectedGraphNode(node.label);;
        UndirectedGraphNode pointer = newCurrent;
        Queue<UndirectedGraphNode> newQ = new LinkedList<>();
        newQ.add(newCurrent);

        while (!q.isEmpty()) {
            UndirectedGraphNode d = q.poll();
            newCurrent = newQ.poll();
            for (UndirectedGraphNode neighbor : d.neighbors) {
                if (neighbor.label == d.label) {
                    newCurrent.neighbors.add(newCurrent);
                } else {
                    // > label, 根据定义，neighbors中不会存小于当前label的node
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    newCurrent.neighbors.add(newNeighbor);

                    q.add(neighbor);
                    newQ.add(newNeighbor);
                }
            }
        }
        return pointer;
    }


    /**
     * BFS解法
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        // 用map存储已经访问过的节点
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(newNode.label, newNode);


        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode n = q.poll();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                // 首先判断节点是否之前已经被访问，如果被访问，则直接从map中取出，否则才新建一个
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    q.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return newNode;
    }


    /**
     * DFS解法
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return doClone(node, map);
    }

    private UndirectedGraphNode doClone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode n : node.neighbors) {
            clone.neighbors.add(doClone(n, map));
        }
        return clone;
    }






        public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

    }
}

package me.leetcode3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author paranoidq
 * @since 1.0.0
 */
public class P138 {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;


    /**
     * 非常巧妙的解法！！！
     *
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // step1: 1->1'->2->2'->3->3'
        RandomListNode c = head;
        while (c != null) {
            RandomListNode next = c.next;
            c.next = new RandomListNode(c.label);
            c.next.next = next;
            c = next;
        }

        // step2: copy random link
        c = head;
        while (c != null) {
            if (c.random != null) {
                c.next.random = c.random.next;
            }
            c = c.next.next;
        }

        // step2: separate origin and copied
        c = head;
        RandomListNode copyHead = head.next;
        RandomListNode copy = copyHead;
        while (copy.next != null) {
            c.next = c.next.next;
            c = c.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }

        // 末尾要断开
        c.next = c.next.next;

        return copyHead;

    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // copy all nodes
        RandomListNode p = head;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }

        // copy link
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}

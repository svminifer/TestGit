package algorithm.cached;

import java.util.HashMap;

/**
 * 注意 DList初始化后，key、val默认为0，因此尾节点应该是key、val为0，next为0的节点
 * @Author kaboso
 * @Date 2021/4/4
 */
public class LRUCache {

    class DList{
        public int key,val;
        public DList pre;
        public DList next;

        public DList(){}
        public DList(int key, int val) {
            this.key = key;
            this.val = val;
        }

        //删除节点
        public void remove(DList dList) {
            if (dList.pre == null){
                cache=dList.next;
                return;
            }

            DList pre=dList.pre;
            DList next=dList.next;

            pre.next=next;
            next.pre=pre;

        }
        //添加新节点到头部
        public void addFirst(DList dList) {
            DList dummy=cache;
            dList.next=dummy;
            dummy.pre=dList;

            cache=dList;

        }
        //获取最后节点
        public DList removeLast() {
            DList dummy=cache;
            while(dummy !=null){
                if (dummy.next.next == null) break;
                dummy=dummy.next;
            }

            remove(dummy);//删除这个节点

            return dummy;
        }
    }

    private HashMap<Integer,DList> map;
    private DList cache;
    private int cap;

    public LRUCache(int capacity) {
        cache=new DList();
        map = new HashMap<>();
        this.cap=capacity;
    }

    /**
     * 1.从map中获取对应的缓存值，将对应的缓存值放到双向链表前面
     *
     */
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val=map.get(key).val;//映射表对应的缓存值

        put(key,val);//将该缓存值放到双向链表前面，过程中会将该值之前的缓存位置删除
        return val;
    }

    public void put(int key, int value) {
        DList node=new DList(key,value);

        //在缓存中
        if (map.containsKey(key) && map.containsValue(value)) {
            cache.remove(map.get(key));//删除旧节点
            cache.addFirst(node);//将新节点放在双向链表前面
            //不在缓存中
        } else {
            //缓存满了
            if (map.size() == cap) {
                DList last=cache.removeLast();
                map.remove(last.key);
            }

            cache.addFirst(node);
            map.put(key,node);
        }

    }

    public static void main(String[] args) {
//        测试一
//        LRUCache lRUCache = new LRUCache(   2);
//        lRUCache.put(1,1);
//        lRUCache.put(2,2);
//
//        System.out.println(lRUCache.get(1));
//        lRUCache.put(3,3);
//
//        System.out.println(lRUCache.get(2));   // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//
//        System.out.println(lRUCache.get(1));// 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));// 返回 3s
//        System.out.println(lRUCache.get(4));// 返回 4
//        测试一

//        测试二
//        LRUCache lRUCache = new LRUCache(   1);
//        lRUCache.put(2,1);
//
//        System.out.println(lRUCache.get(2));
//        测试二

//        测试三
//        LRUCache lRUCache = new LRUCache(   2);
//        lRUCache.put(2,1);
//        lRUCache.put(2,2);
//        System.out.println(lRUCache.get(2));
//        lRUCache.put(1,1);
//        lRUCache.put(4,2);
//        System.out.println(lRUCache.get(2));

//        测试三
//        测试四
        LRUCache lRUCache = new LRUCache(   2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2,6);
        System.out.println(lRUCache.get(1));
        lRUCache.put(1,5);
        lRUCache.put(1,2);
        System.out.println(lRUCache.get(1));

        System.out.println(lRUCache.get(2));
//        测试四




    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

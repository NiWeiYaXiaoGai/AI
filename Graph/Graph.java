package main.java.ChinaHadoop_AI_Offer.Graph;

import java.util.ArrayList;
import java.util.List;


/**
 * 有关内部类的泛型使用https://blog.csdn.net/chenkangqiang/article/details/56668118
 * @param <E>
 */

/**
 * 连通图：在无向图中，若任意两个顶点vivi与vjvj都有路径相通，则称该无向图为连通图。
 * 连通网：在连通图中，若图的边具有一定的意义，每一条边都对应着一个数，称为权；权代表着连接两个顶点的代价，这种连通图叫做连通网。
 *生成树：一个连通图的生成树是指一个连通子图，它含有图中全部n个顶点，但只有足以构成一棵树的n-1条边。
         一颗有n个顶点的生成树有且仅有n-1条边，如果生成树中再添加一条边，则必定成环。
 *最小生成树：在连通网的所有生成树中，所有边的代价和最小的生成树，称为最小生成树。
 * 图的深度优先搜索即前序遍历
 * 图的宽度优先搜索即层序遍历
 */
public class Graph<E> {
    int capacity; //最多容纳顶点数
    int size; //图中顶点个数
    Node<E>[] nodes; //节点数组
    boolean[] isVisited;
    int[][] matrix; //邻接矩阵

    private class Node<E>{
        E val;
        boolean isVisited;
        public Node(E val) {
            this.val = val;
        }
    }

    public Graph(int capacity) {
        this.capacity = capacity;
        size=0;
        nodes=new Node[capacity];
        matrix=new int[capacity][capacity];

    }

    public void add(E e){
        if(e==null)
            throw new IllegalArgumentException("element is null!!!!!!!!");
        if(size>=capacity)
            throw new IllegalArgumentException("Has exceeded graph capacity!!!!!!");
        nodes[size]=new Node<>(e);
        size++;
    }

    //将图中所有节点的遍历状态设置成未遍历
    private void resetGraph(){
        for(int i=0;i<size;i++){
            nodes[i].isVisited=false;
        }
    }

    //设置有向图的邻接矩阵
    public void setMatForDirectedGraph(int row,int col,int weight){
        if(row<0 && row>=size && col<0 && col>=size)
            throw new IllegalArgumentException("Has exceeded graph boundary!!!!!!");
        matrix[row][col]=weight;
    }
    public void setMatForDirectedGraph(int row,int col){
        if(row<0 && row>=size && col<0 && col>=size)
            throw new IllegalArgumentException("Has exceeded graph boundary!!!!!!");
        matrix[row][col]=1;
    }

    //设置无向图的邻接矩阵
    public void setMatForUnDirectedGraph(int row,int col,int weight){
        if(row<0 && row>=size && col<0 && col>=size)
            throw new IllegalArgumentException("Has exceeded graph boundary!!!!!!");
        matrix[row][col]=weight;
        matrix[col][row]=weight;
    }
    public void setMatForUnDirectedGraph(int row,int col){
        if(row<0 && row>=size && col<0 && col>=size)
            throw new IllegalArgumentException("Has exceeded graph boundary!!!!!!");
        matrix[row][col]=1;
        matrix[col][row]=1;
    }

    //深度优先遍历
    public void depthFirstTraverse(int index){
        resetGraph();
        depthFirstTraverseImpl(index);
    }
    private void depthFirstTraverseImpl(int index){
        System.out.println(nodes[index].val);
        nodes[index].isVisited=true;
        for(int i=0;i<size;i++){
            if(matrix[index][i]!=0){
                if(nodes[i].isVisited==false){
                    depthFirstTraverseImpl(i);
                }else{
                    continue;
                }
            }else{
                continue;
            }
        }
    }

    /**
     * 宽度优先遍历
     * @param index 根节点索引
     */
    public void breadthFirstTraverse(int index){
        resetGraph();
        nodes[index].isVisited=true;
        List<Integer> cur=new ArrayList<>();
        cur.add(index);
        breadthFirstTraverseImpl(cur);
    }

    /**
     * 宽度优先遍历递归函数
     * @param pre 上一层的节点集合
     */
    private void breadthFirstTraverseImpl(List<Integer> pre){
        List<Integer> cur=new ArrayList<>();
        for(int i=0;i<pre.size();i++){ //遍历上一层的节点
            System.out.println(nodes[pre.get(i)].val);
            for(int j=0;j<size;j++){   //遍历上一层节点子节点
                if(matrix[pre.get(i)][j]!=0){
                    if(!nodes[j].isVisited) {  //如果当前节点没有被遍历
                        nodes[j].isVisited=true;
                        cur.add(j);
                    } else
                        continue;
                }else{
                    continue;
                }
            }
        }
        if(cur.size()==0)
            return;
        else
            breadthFirstTraverseImpl(cur);
    }

    /**
     * 生成图的最小生成树
     * 普利姆算法
     * @return
     */
    private class Edge{
        private int nodeA;
        private int nodeB;
        private int weight;
        private boolean isSelected;

        public Edge(int nodeA, int nodeB, int weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
            this.isSelected=false;
        }
    }

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder("图的邻接矩阵为：\n");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                str.append(matrix[i][j]+"\t");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        //1.图的广度和深度优先遍历测试
        /**
         *                    A
         *                  /   \
         *                B      D
         *               / \    / \
         *              C   F  G   H
         *              \  /
         *               E
         */
        Graph<Character> graph=new Graph<>(8);
        graph.add('A');
        graph.add('B');
        graph.add('C');
        graph.add('D');
        graph.add('E');
        graph.add('F');
        graph.add('G');
        graph.add('H');
        graph.setMatForUnDirectedGraph(0,1);
        graph.setMatForUnDirectedGraph(0,3);
        graph.setMatForUnDirectedGraph(1,2);
        graph.setMatForUnDirectedGraph(1,5);
        graph.setMatForUnDirectedGraph(3,6);
        graph.setMatForUnDirectedGraph(3,7);
        graph.setMatForUnDirectedGraph(6,7);
        graph.setMatForUnDirectedGraph(2,4);
        graph.setMatForUnDirectedGraph(4,5);
        System.out.println(graph);
        System.out.println("图的深度优先遍历：");
        graph.depthFirstTraverse(0);
        System.out.println("图的宽度优先遍历：");
        graph.breadthFirstTraverse(0);


        //2.最小生成树的测试
        /**
         *                    A
         *                 /  |  \
         *               B ---F---E
         *                \  / \ /
         *                 C ---D
         *
         */
    }
}

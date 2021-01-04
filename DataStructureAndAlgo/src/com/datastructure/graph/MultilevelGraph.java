package com.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultilevelGraph {

 /* public GNode constructGnode(List<CsvDataFeedModel> csvDataFeedModelList) {
    Map<Integer, GNode> gNodeMap = new HashMap<>();
    GNode gNode = null;
    for (int i = 0; i < csvDataFeedModelList.size(); i++) {
      GNode parent = gNodeMap.get(csvDataFeedModelList.get(i).parent;
      if (null == parent){
        List<GNode> children = new ArrayList<>();
        //children.add("" + csvDataFeedModelList.get(i).child);
        parent = new GNode("" + csvDataFeedModelList.get(i).parent, null,
            );

      }
    }

  }
*/
}


class CsvDataFeedModel {
  Integer parent;
  Integer child;

}


class GNode {
  String name;
  String parent;
  List<String> children;

  public GNode(String name, String parent, List<String> children) {
    this.name = name;
    this.parent = parent;
    this.children = children;
  }


}

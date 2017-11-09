package com.netcracker.edu.java.tasks;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by dimon on 19.08.17.
 */
public class TreeNodeImpl implements TreeNode {
    private TreeNode parent;
    private ArrayList<TreeNode> childrenArray;
    private Object data;
    private boolean expanded;

    public TreeNodeImpl() {
        parent = null;
        childrenArray = null;
        data = null;
        expanded = false;
    }

    @Override
    public TreeNode getParent() {
        return this.parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        TreeNode root = this.getParent();
        if (root == null)   return null;
        while (root.getParent() != null) {
            root = root.getParent();
        }
        return root;
    }

    @Override
    public boolean isLeaf() {
        return childrenArray == null || childrenArray.size() == 0;
    }

    @Override
    public int getChildCount() {
        return childrenArray == null ? 0 : childrenArray.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return childrenArray == null ? null : childrenArray.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        if (childrenArray == null) {
            childrenArray = new ArrayList<>();
        }
        childrenArray.add(child);
        child.setParent(this);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if (childrenArray == null)  return false;
        if (childrenArray.contains(child)) {
            childrenArray.remove(child);
            child.setParent(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean isExpanded() {
        return this.expanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        Iterator<TreeNode> it = this.getChildrenIterator();
        while (it.hasNext()) {
            TreeNode child = (TreeNode) it.next();
            child.setExpanded(expanded);
        }
    }

    @Override
    public Object getData() {
        return this.data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        ArrayList<String> array = new ArrayList<>();
        array.add(this.getData() == null ? "empty" : this.getData().toString());
        TreeNode parent = this.getParent();
        while (parent != null) {
            array.add(parent.getData() == null ? "empty" : parent.getData().toString());
            parent = parent.getParent();
        }

        StringBuilder path = new StringBuilder();
        for(int i=array.size()-1; i>0; --i) {
            path.append(array.get(i)).append("->");
        }
        path.append(array.get(0));

        return path.toString();
    }

    @Override
    public TreeNode findParent(Object data) {
        if (this.getData().equals(data))    return this;
        else if (this.getParent() != null)  return this.getParent().findParent(data);
        else                                return null;
    }

    @Override
    public TreeNode findChild(Object data) {
        Iterator<TreeNode> it = this.getChildrenIterator();
        TreeNode toFind = null;
        while (it.hasNext() && toFind == null) {
            TreeNode child = (TreeNode) it.next();
            if (child.getData() != null) {
                toFind = child.getData().equals(data) ? child : child.findChild(data);
            } else {
                toFind = data == null ? child : child.findChild(data);
            }
        }
        return toFind;
    }
}
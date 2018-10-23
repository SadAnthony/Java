package ru.skillbench.tasks.javaapi.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeNodeImpl implements TreeNode {
    private TreeNode parent = null;
    private ArrayList<TreeNode> children = new ArrayList<>();
    private boolean isExpanded = false;
    private Object data = null;
    static private int countRoot = 0;

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if (this.parent == null && countRoot == 0) {
            return null;
        } else if (this.parent == null) {
            countRoot = 0;
            return this;
        } else {
            countRoot++;
            return this.parent.getRoot();
        }
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return children.listIterator();
    }

    @Override
    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if (children.remove(child)) {
            child.setParent(null);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isExpanded() {
        return isExpanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.isExpanded = expanded;
        for (TreeNode t : children) {
            t.setExpanded(expanded);
        }
    }

    @Override
    public Object getData() {
        if (this.data == null) {
            return null;
        } else {
            return this.data;
        }
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        String str;
        if (this.data == null) {
            str = "empty";
        } else {
            str = this.getData().toString();
        }
        if (this.getRoot() == null) {
            return str;
        } else {
            return this.parent.getTreePath() + "->" + str;
        }
    }

    @Override
    public TreeNode findParent(Object data) {
        if (data == null) {
            if (this.data == null) {
                return this;
            } else if (this.parent == null) {
                return null;
            } else {
                return this.parent.findParent(null);
            }
        } else if (data.equals(this.data)) {
            return this;
        } else if (this.parent == null) {
            return null;
        } else {
            return this.parent.findParent(data);
        }
    }

    @Override
    public TreeNode findChild(Object data) {
        TreeNode t;
        if (data == null) {
            if (this.data == null) {
                return this;
            } else if (children.isEmpty()) {
                return null;
            } else {
                for (TreeNode i : children) {
                    t = i.findChild(null);
                    if (t != null) {
                        return t;
                    }
                }
            }
        } else {
            if (this.data.equals(data)) {
                return this;
            } else if (children.isEmpty()) {
                return null;
            } else {
                for (TreeNode i : children) {
                    t = i.findChild(data);
                    if (t != null) {
                        return t;
                    }
                }
            }
        }
        return null;
    }
}

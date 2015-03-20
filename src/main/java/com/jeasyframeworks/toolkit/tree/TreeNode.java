package com.jeasyframeworks.toolkit.tree;

import java.util.List;

public interface TreeNode<T> {

	public long getId();

	public long getParentId();

	public List<TreeNode<T>> getChildren();

	public void setChildren(List<TreeNode<T>> children);

}

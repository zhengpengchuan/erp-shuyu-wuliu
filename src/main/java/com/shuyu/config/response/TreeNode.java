package com.shuyu.config.response;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode implements Serializable {

	protected Long id;

	protected Long parentId;

	protected List<TreeNode> children = new ArrayList<TreeNode>();

	protected Boolean hasChildren;

	public void add(TreeNode node) {
		children.add(node);
	}

}

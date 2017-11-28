/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* trimBST(TreeNode* root, int L, int R) {
    	if (root == NULL)
    		return NULL;
        TreeNode* rlt;
        if (L <= root->val && root->val <= R)
        {
        	rlt = new TreeNode(root->val);
        	rlt->left = trimBST(root->left, L, R);
        	rlt->right = trimBST(root->right, L, R);
        }
        else if (root->val > R)
        {
        	rlt = trimBST(root->left, L, R);
        }
        else if (root->val < L)
        {
        	rlt = trimBST(root->right, L, R);
        }

        return rlt;
    }
};
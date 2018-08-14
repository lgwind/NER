/**
 * 显示修改弹出层界面
 * @returns
 */
function showUpdate(){
	$$("userUpdate").style.display="inline";
}

/**
 * 关闭遮罩和修改弹出层界面
 * @returns
 */
function closeUserUpdate(){
	$$("userMask").style.display="none";
	$$("userUpdate").style.display="none";
}

/**
 * 显示添加弹出层界面
 * @returns
 */
function showAdd(){
	$$("userAdd").style.display="inline";
}

/**
 * 关闭遮罩和添加弹出层界面
 * @returns
 */
function closeUserAdd(){
	$$("userMask").style.display="none";
	$$("userAdd").style.display="none";
}
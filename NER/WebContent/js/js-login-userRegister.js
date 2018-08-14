/**
 * 显示添加弹出层界面
 * @returns
 */
function showRegister(){
	$$("userRegister").style.display="inline";
}

/**
 * 关闭遮罩和添加弹出层界面
 * @returns
 */
function closeUserRegister(){
	$$("userMask").style.display="none";
	$$("userRegister").style.display="none";
}
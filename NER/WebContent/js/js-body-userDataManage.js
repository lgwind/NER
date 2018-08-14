/**
 * 显示导出xls文件弹出层界面
 * @returns
 */
function showXLSPopup(){
	$$("exportXLSPopup").style.display="inline";
}

/**
 * 关闭遮罩和导出xls文件弹出层界面
 * @returns
 */
function closeXlSPopup(){
	$$("userMask").style.display="none";
	$$("exportXLSPopup").style.display="none";
}

/**
 * 显示导出csv文件弹出层界面
 * @returns
 */
function showCSVPopup(){
	$$("exportCSVPopup").style.display="inline";
}

/**
 * 关闭遮罩和导出csv文件弹出层界面
 * @returns
 */
function closeCSVPopup(){
	$$("userMask").style.display="none";
	$$("exportCSVPopup").style.display="none";
}

/**
 * 显示修改弹出层界面
 * @returns
 */
function showUpdate(){
	$$("dataUpdate").style.display="inline";
}

/**
 * 关闭遮罩和修改弹出层界面
 * @returns
 */
function closeDatasUpdate(){
	$$("userMask").style.display="none";
	$$("dataUpdate").style.display="none";
}

/**
 * 显示添加弹出层界面
 * @returns
 */
function showAdd(){
	$$("dataAdd").style.display="inline";
}

/**
 * 关闭遮罩和添加弹出层界面
 * @returns
 */
function closeDatasAdd(){
	$$("userMask").style.display="none";
	$$("dataAdd").style.display="none";
}
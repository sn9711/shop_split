function $(idName) {
    return document.getElementById(idName);
}
function delRow(tag) {
    var tr = tag.parentNode.parentNode;
    var tbody = $("tbody");
    tbody.removeChild(tr);
}
function selectAll() {
    //1.�����ҳ���е�input��ǩ
    var inps = document.getElementsByTagName("input");
    //2.������������е�����Ϊcheckbox�ı�ǩ
    for (var i = 0; i < inps.length; i++) {
        if (inps[i].type == "checkbox") {
            inps[i].checked = "checked";
        }
    }
}
function quxiao() {
    var inps = document.getElementsByTagName("input");
    for (var i = 0; i < inps.length; i++) {
        if (inps[i].type == "checkbox") {
            inps[i].checked = "";
        }
    }
}
function deleteSelected() {
    var inps = document.getElementsByTagName("input");
    for (var i = inps.length - 1; i >= 0; i--) {
        if (inps[i].checked) {
            delRow(inps[i]);
        }
    }
}
function over(tag) {
    tag.style.color = "white";
    tag.style.backgroundColor = "pink";
}
function out(tag) {
    tag.style.color = "black";
    tag.style.backgroundColor = "white";
}
function sub(tag) {
    var numtxt = tag.nextSibling; //����������ı���
    var price = tag.parentNode.previousSibling.innerHTML;//��ü۸���
    var num = numtxt.value; //��������ı�������
    if (num > 1) {
        num = num - 0 - 1;
    }
    numtxt.value = num + "";
    var totalprice = price * num; //����ܼ�
    //����ܼ��ı���,�����ܼ�
    tag.parentNode.nextSibling.innerHTML = totalprice;
}
function add(tag) {
    var numtxt = tag.previousSibling; //����������ı���
    //��ü۸���,�������۸��ǩʱ�س������ˣ�
    //��ônextSibling�õ������ı��ڵ㣬�����ı���
    var price = tag.parentNode.previousSibling.innerHTML;
    var num = numtxt.value; //��������ı�������

    if (num < 9) {
        num = num - 0 + 1;
    }
    numtxt.value = num + "";
    var totalprice = price * num; //����ܼ�

    //����ܼ��ı���,�����ܼ�
    tag.parentNode.nextSibling.innerHTML = totalprice;
}
function init() {
    var inps = document.getElementsByTagName("input");
    for (var i = 0; i < inps.length; i++) {
        if (inps[i].type == "text") {
            if (inps[i].previousSibling.type == "button") {
                inps[i].value = 1;
            } else {
                inps[i].value = "";
            }
        }
    }
}
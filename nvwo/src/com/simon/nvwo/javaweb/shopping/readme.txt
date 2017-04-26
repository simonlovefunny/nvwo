
1.session实现简易购物车

Session的作用主要是跨页面传递信息

step1.jsp 选择要购买的商品

ProcessStep1.servlet 将数据存到HttpSession

step2.jsp 输入信用卡和地址信息

ProcessStep2.servlet 将数据存到HttpSession

confirm.jsp 确认输入的信息

2.防止表单重复提交

在表单中做标记，提交到servlet中时若请求和预定义一致，则受理请求，否则给出重复提交警告信息

form.jsp 提交表单

TokenServlet	防止重复提交

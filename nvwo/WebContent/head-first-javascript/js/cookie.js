function writeCookie(name, value, days) {
  // 默认情况下，过期时间为空，则cookie不会被长期保存
  var expires = "";

  //指定cookie保存的天数 	
  if (days) {
    var date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    expires = "; expires=" + date.toGMTString();
  }

  // 为cookie设置名称，值和过期时间
  document.cookie = name + "=" + value + expires + "; path=/";
}

function readCookie(name) {
  // 按照cookie名字找到对应的值
  var searchName = name + "=";
  var cookies = document.cookie.split(';');
  for(var i=0; i < cookies.length; i++) {
    var c = cookies[i];
    while (c.charAt(0) == ' ')
      c = c.substring(1, c.length);
    if (c.indexOf(searchName) == 0)
      return c.substring(searchName.length, c.length);
  }
  return null;
}

function eraseCookie(name) {
  // 消除特定的cookie
  writeCookie(name, "", -1);
}

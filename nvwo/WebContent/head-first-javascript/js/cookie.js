function writeCookie(name, value, days) {
  // Ĭ������£�����ʱ��Ϊ�գ���cookie���ᱻ���ڱ���
  var expires = "";

  //ָ��cookie��������� 	
  if (days) {
    var date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    expires = "; expires=" + date.toGMTString();
  }

  // Ϊcookie�������ƣ�ֵ�͹���ʱ��
  document.cookie = name + "=" + value + expires + "; path=/";
}

function readCookie(name) {
  // ����cookie�����ҵ���Ӧ��ֵ
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
  // �����ض���cookie
  writeCookie(name, "", -1);
}

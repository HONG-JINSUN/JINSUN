/**
 * 
 */

 
 function loginCheck(){
 if ( document.frm.id.value == "" ){
 alert ("아이디를 써주세요");
 frm.id.focus();
 return false;
 } else if ( document.frm.pwd.value == "" ){
 alert ("비밀번호를 써주세요");
 frm.pwd.focus();
 return false;
 } else {
 return true;
 }
 }
/**
 * 
 */
 
 function check(){
 if ( document.frm.name.value == "" ){
 alert("이름을 입력해주세요.");
 document.frm.name.focus();
 return false;
 } else if ( document.frm.inumber.value ==""){
 alert("주민등록번호를 입력해주세요.");
 document.frm.inumber.focus();
 return false;
   } else if (isNaN(document.frm.inumber.value)){
 alert("숫자를 입력해주세요.");
 document.frm.inumber.focus();
 return false;
 } else if ( document.frm.inumber2.value ==""){
 alert("주민등록번호를 입력해주세요.");
 document.frm.inumber2.focus();
 return false;
   } else if (isNaN(document.frm.inumber2.value)){
 alert("숫자를 입력해주세요.");
 document.frm.inumber.focus();
 return false;
  } else if ( document.frm.id.value ==""){
 alert("아이디를 입력해주세요.");
 document.frm.id.focus();
 return false;
  } else if ( document.frm.pwd.value ==""){
 alert("비밀번호를 입력해주세요.");
 document.frm.pwd.focus();
 return false;
  } else if ( document.frm.pwd2.value != document.frm.pwd.value){
 alert("비밀번호를 확인해주세요.");
 document.frm.pwd2.focus();
 return false;
  } else if ( document.frm.email.value ==""){
 alert("이메일을 입력해주세요.");
 document.frm.email.focus();
 return false;
  } else if ( document.frm.anumber.value ==""){
 alert("우편번호를 입력해주세요.");
 document.frm.anumber.focus();
 return false;
   } else if (isNaN(document.frm.anumber.value)){
 alert("숫자를 입력해주세요.");
 document.frm.anumber.focus();
 return false;
  } else if ( document.frm.add.value ==""){
 alert("주소를 입력해주세요.");
 document.frm.add.focus();
 return false;
  } else if ( document.frm.add2.value ==""){
 alert("나머지 주소를 입력해주세요.");
 document.frm.add2.focus();
 return false;
  } else if ( document.frm.pnumber.value ==""){
 alert("전화번호를 입력해주세요.");
 document.frm.pnumber.focus();
 return false;
    } else if (isNaN(document.frm.pnumber.value)){
 alert("숫자를 입력해주세요.");
 document.frm.pnumber.focus();
 return false;
   } else if ( document.frm.job2.value ==""){
 alert("직업을 선택해주세요.");
 document.frm.job2.focus();
 return false;
 } else {
 return true;
 }
 }
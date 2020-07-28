/**
 * 
 */
 
 /**
 * 
 */
 
 function loginCheck(){
 if ( document.frm.custname.value == "" ){
 alert ("아이디를 써주세요");
 frm.custname.focus();
 return false;
 } else if ( document.frm.phone.value == "" ){
 alert ("전화번호를 써주세요");
 frm.phone.focus();
 return false;
 } else if ( document.frm.address.value == "" ){
 alert ("주소를 써주세요");
 frm.address.focus();
 return false;
 } else if ( document.frm.joindate.value == "" ){
 alert ("가입날짜를 써주세요");
 frm.joindate.focus();
 return false;
 } else if ( document.frm.grade.value == "" ){
 alert ("등급를 써주세요");
 frm.grade.focus();
 return false;
 } else if ( document.frm.city.value == "" ){
 alert ("도시코드를 써주세요");
 frm.city.focus();
 return false;
 } else {
 alert ("회원가입완료");
 return true;
 }
 }
 
  function loginCheck2(){
 if ( document.frm.custname.value == "" ){
 alert ("아이디를 써주세요");
 frm.custname.focus();
 return false;
 } else if ( document.frm.phone.value == "" ){
 alert ("전화번호를 써주세요");
 frm.phone.focus();
 return false;
 } else if ( document.frm.address.value == "" ){
 alert ("주소를 써주세요");
 frm.address.focus();
 return false;
 } else if ( document.frm.joindate.value == "" ){
 alert ("가입날짜를 써주세요");
 frm.joindate.focus();
 return false;
 } else if ( document.frm.grade.value == "" ){
 alert ("등급를 써주세요");
 frm.grade.focus();
 return false;
 } else if ( document.frm.city.value == "" ){
 alert ("도시코드를 써주세요");
 frm.city.focus();
 return false;
 } else {
 alert ("수정완료");
 return true;
 }
 }


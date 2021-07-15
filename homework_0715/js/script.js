function sendit(){

    const userid = document.getElementById('userid');
    const userpw = document.getElementById('userpw');
    
    const userpw_re = document.getElementById('userpw_re');
    const name = document.getElementById('name');
    const hp = document.getElementById('hp');
    const email = document.getElementById('email');
    const hobby = document.getElementsByName('hobby');  // 복수로 써줘야함
    const ssn1 = document.getElementById('ssn1');
    const ssn2 = document.getElementById('ssn2');
    const isssn = document.getElementById('isssn');

    // 정규표현식
    const expNameText = /[가-힣]+$/;
    const expHpText = /^010\d{3,4}\d{4}$/;  // 010부터
    const expPwText =/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
    // 비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 함
    const exEmailText = /^[A-Za-z0-9\.\-]+@[A-Za-z0-9\.\-]+\.[A-Za-z0-9]+$/
    // aA.-0123@aA.-0123.com(kr)


    // 아이디를 입력하지 않았을 경우
    if(userid.value == ''){
        alert('아이디를 입력하세요.');
        userid.focus(); // 입력할 수 있게 작성칸을 가르킴
        return false;   // 입력안하면, 넘어가지 않고 문구 띄어라.
    }

    // 아이디가 4자 미만 또는 16자를 초과하는 경우
    if(userid.value.length < 4 || userid.value.length > 16){    
        alert('아이디를 4자 이상 16자 이하로 입력하세요.'); // db에서 튕기기전에 먼저 정리
        userid.focus();
        return false;
    }

    // 비밀번호를 입력하지 않은 경우
    if(userpw.value == ''){
        alert('비밀번호를 입력하세요.');
        userpw.focus();
        return false;
    }
    if(!expPwText.test(userpw.value)){
        alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해주세요.');
        userpw.focus();
        return false;
    }

    // 비밀번호와 비밀번호 확인의 값이 다른 경우
    if(userpw.value != userpw_re.value){
        alert('비밀번호와 비밀번호 확인의 값이 다릅니다.');
        userpw_re.focus();
        return false;
    }

    // 이름을 체크하는 경우
    if(!expNameText.test(name.value)){  // 한글이 여부
        alert('이름 형식을 확인하세요.\n한글만 입력 가능합니다.');
        name.focus();
        return false;
    }

    // 휴대폰 번호 체크하는 경우
    if(!expHpText.test(hp.value)){
        alert('휴대폰번호 형식을 확인하세요.');
        hp.focus();
        return false;
    }

    // 이메일 체크하는 경우
    if(!exEmailText.test(email.value)){
        alert('이메일 형식을 확인하세요.');
        email.focus();
        return false;
    }

    // 취미 
    let count = 0;
    for(let i in hobby){
        if(hobby[i].checked){
            count++;
        }
    }
    if(count == 0){
        alert('취미는 1개이상 선택하세요.');
        return false;
    }

    // 주민등록번호 써야 넘김
    if(isssn.value == 'n'){
        alert('주민등록번호 검증을 눌러주세요.');
        return false;
    }
    

    return true;
}


// 주민등록번호 유효여부
function ssnCheck(){
    const ssn1 = document.getElementById('ssn1');
    const ssn2 = document.getElementById('ssn2');
    const isssn = document.getElementById('isssn');
    
    if(ssn1.value == '' || ssn2.value == ''){
        alert('주민등록번호를 입력하세요.');
        ssn1.focus();
        return false;
    }
    const ssn = ssn1.value + ssn2.value;    // 001011 3068518

    const s1 = Number(ssn.substr(0, 1)*2);
    const s2 = Number(ssn.substr(1, 1)*3);
    const s3 = Number(ssn.substr(2, 1)*4);
    const s4 = Number(ssn.substr(3, 1)*5);
    const s5 = Number(ssn.substr(4, 1)*6);
    const s6 = Number(ssn.substr(5, 1)*7);
    const s7 = Number(ssn.substr(6, 1)*8);
    const s8 = Number(ssn.substr(7, 1)*9);
    const s9 = Number(ssn.substr(8, 1)*2);
    const s10 = Number(ssn.substr(9, 1)*3);
    const s11 = Number(ssn.substr(10, 1)*4);
    const s12 = Number(ssn.substr(11, 1)*5);
    const s13 = Number(ssn.substr(12, 1));

    let result = s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12;
    result = result % 11;
    result = 11 - result;
    if(result >= 10) result = result % 10;

    if(result == s13){
        alert('주민등록번호가 유효합니다.');
        isssn.value = 'y';
    }else{
        alert('주민등록번호가 유효하지 않습니다.');
    }

}

function moveFocus(){
    const ssn1 = document.getElementById('ssn1');
    if(ssn1.value.length >= 6){
        document.getElementById('ssn2').focus();    // 포커스 옮겨감
    }
}

function changeSsn(){
    const isssn = document.getElementById('isssn');
    isssn.value = 'n';
}
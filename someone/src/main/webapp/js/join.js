//아이디 중복 확인
function check_id(){
	
	id= $("#j_id").val();
	console.log("중복 확인에서 받은 id: "+id);
	
	$.ajax({
		type : "get",
		async : false,
		dataType : "text",
		url : "http://localhost:8080/join_check.vm",
		//보내는 데이터
		data: {
			id_: id,
		},
		//날라오는 데이터
		success : function(data, textStatus) {
			console.log("받은 data는  "+data);
			console.log("받은 textStatus는 :"+textStatus);
			
			if(data === "true"){
				alert("아이디 사용 불가 합니다");
				$("#j_id").val("");
				//$("input[name=checked_id]").val('no');
			}else{
				alert("아이디 사용 가능");
				$("input[name=checked_id]").val('yes');
				
			}				
		},
		error : function(data, textStatus) {
			console.log("에러가 발생")
			alert("입력 정보가 맞지 않습니다.");
		},
		complete : function(data, textStatus) {
			console.log("전송 완료되었습니다.")
		}

	});
}

//계정 생성
function join_create(){
	
	
    //만약 회원가입창에 빈칸이 있으면 정보를 모두 입력하세요 출력
    if($("#j_id").val() === "" ||
        $("#passord1").val() === "" ||
        $("#j_pw").val() === "" ||
        $("#j_name").val() === "" ||
        $("#j_email").val() === ""
        ){
        	alert('정보가 다 입력되지 않았습니다.');
        	//만약 아이디 중복 확인을 눌렀을 때 yes면 밑에 줄력
         }else if($("input[name=checked_id]").val()==""){
         	alert('아이디 중복 확인을 해주세요');
         }else if($('#pwConfirm').text()=='비밀번호 틀림'){
         	alert('비밀번호가 일치하지 않습니다');
         }else if($("input[name=checked_id]").val()=="yes") {       	
            //계정 정보 db에 넘기기
            $.ajax({
                type : "get",
                async : false,
                dataType : "text",
                url : "http://localhost:8080/insertMembers.vm",
                data : {
                    j_id: $("#j_id").val(),
                    j_pw: $("#j_pw").val(),
                    j_name: $("#j_name").val(),
                    j_email: $("#j_email").val()
                },
                success: function(data, textStatus) {
                console.log("성공");
                },
                error: function(data, textStatus) {
                    console.log("에러가 발생")
                },
                complete: function(data, textStatus) {
                    console.log("전송 완료되었습니다.")
                }
            });	    
            
            if(confirm("계정 생성을 하시겠습니까?")){
		            alert("계정 생성이 완료 되었습니다.");
		            location.href="index.html"
		        }else{
		            alert("계정 생성이 취소되었습니다.");
		            //location.reload(true);
		        }          
        }

}         

    
    
//패스워드 확인
function password_check(){
    	if($('#password1').val() == $('#j_pw').val()){
    		$('#pwConfirm').text('비밀번호 일치').css('color','green')
    	}else{
    		$('#pwConfirm').text('비밀번호 틀림').css('color','red')
    		// password1에서 텍스트를 뗐
    	}
    	
    }
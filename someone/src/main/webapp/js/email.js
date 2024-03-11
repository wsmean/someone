//프로필 아이디 맞춰서 변경
const p_id = localStorage.getItem('my_id');
	
window.onload = function(){
	console.log(p_id);
	$('#profile_id').text(p_id);
}

//회원 탈퇴
function join_out(){
        if(confirm("탈퇴하시겠습니까?\n탈퇴시 모든 정보가 사라집니다.")){
            alert('탈퇴가 완료 되었습니다.');
            //탈퇴시 모든 정보 삭제 (아이디+랜덤 질문 답변한거)
            $.ajax({
                type : "get",
                async : false,
                dataType : "text",
                url : "http://localhost:8080/deleteMembers1.vm",
                data : {
                    j_id1: p_id
                },
                success: function(data, textStatus) {
                	console.log("Ajax에서 받은 값 : "+data);
                	console.log("성공");
                },
                error: function(data, textStatus) {
                    console.log("에러가 발생")
                },
                complete: function(data, textStatus) {
                    console.log("전송 완료되었습니다.")
                }
            });	    
            localStorage.clear();
            location.href="index.html"
            
        }else{
            alert('탈퇴가 취소 되었습니다.');
            //굳이 안써도됨 location.reload(true);쓰면 새로고침이라 정보 날아감
        }
    }
        
let random_question;   
 
//random_quesiton 데이터 호출
function loadDBData() {
	$.ajax({
		type : "get",
		async : false,
		dataType : "text",
		url : "http://localhost:8080/loadrandom_question.vm",
		success : function(data, textStatus) {
			random_question = JSON.parse(data);
			console.log(random_question);
			$("#question").text(random_question[0].question);
			$("#create_ran").attr("disabled", true);	
			$("#create_ran").css({'background-color': 'rgb(255, 190, 233)'});
		},
		error : function(data, textStatus) {
			console.log("에러가 발생")
		},
		complete : function(data, textStatus) {
			console.log("전송 완료되었습니다.")
		}

	});
}

//버튼 누르면 출력
function click_button(){
		const button = document.querySelector('#answer').value;
		mAnswer_Value = document.querySelector('#mAnswer_').innerHTML = button;
		document.querySelector('#answer').value="";
		
		//답변 저장
		$.ajax({
		type: "get",
		async: false,
		dataType: "text",
		url: "http://localhost:8080/saveAnswer.vm",
		data: {
			mAnswer_: mAnswer_Value,
			auto_id: random_question[0].auto
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
		
}



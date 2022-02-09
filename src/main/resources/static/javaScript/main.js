//console.clear();
//
//setTimeout(function(){
//  document.querySelector('input[type="checkbox"]').setAttribute('checked',true);
//},100);

$("input:checkbox[value='true']").prop("checked",true); // 채크됨
$("input:checkbox[value='false']").prop("checked",false); //체크안됨

function checkbox_Checked(this_checkbox){
    console.log(this_checkbox);
    console.log($(this_checkbox));

    const checked = $(this_checkbox).prop("checked");
    const id = $(this_checkbox).prop("id");

    console.log(checked);
    console.log(id);

    const checkbox_status = {  // Json 키 값 = Dto 키 값
        "id" : id,
        "completed" : checked
    };
    console.log(checkbox_status);

    // fetch() - 수정 REST API 호출
    const url = "/daytoday/update/" +checkbox_status.id;
    fetch(url, {
        method: "PATCH",                         // PATCH 요청을 보낼거다.
        body: JSON.stringify(checkbox_status),          // comment JS 객체(수정된 댓글)을 JSON 으로 바꿔서 보낸다.
        headers: {
            "Content-Type": "application/json" // body 에 실어서 보낸게 application/json 타입이다. (여기 안에는 json 이 들어있엉)
        }
    }).then(response => {
            // http 응답 코드에 따른 메세지 출력
            const msg = (response.ok)? "체크박스가 수정되었습니다." : "체크박스 수정 실패!";

     });

}
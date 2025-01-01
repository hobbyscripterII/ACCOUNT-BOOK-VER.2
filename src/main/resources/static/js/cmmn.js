const success = {icon : 'success', title : '성공'};
const error   = {icon : 'error',   title : '실패'};

// SweetAlert
function alertSuccess(text) {
	Swal.fire({
	  icon  : success.icon,
	  title : success.title,
	  text  : `${text}이(가) 정상적으로 완료되었습니다.`,
	});
}

function alertError(text, errorCode) {
	Swal.fire({
	  icon  : error.icon,
	  title : error.title,
	  text  : `${text}이(가) 실패하였습니다. 에러 코드 : ${errorCode}`,
	});
}

$(document).ready(function() {
	// 유효성 검증 - 숫자만 입력 가능
	// (예) data-valid-number="2"
    $('input[data-valid-number]').on('input', function() {
		let $el = $(this); 				    // 입력 이벤트 요소 가져오기
		let max = $el.data('valid-number'); // 최대 입력 가능한 문자열 길이

		// 숫자를 제외한 문자열 필터링
	    let text_  = $el.val();
	    let text   = text_.replace(/[^0-9]/g, '');
		let length = text.length;
		
	    // 비숫자 제거 & 길이가 넘지 않도록 문자열 길이 초과 시 자르기
	    if (length > max) {
	        text = text.substring(0, max);
	    }

		// 수정된 값으로 다시 설정
	    $el.val(text);
	});
});
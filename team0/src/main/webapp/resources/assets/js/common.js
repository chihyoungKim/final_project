
//리뷰, 정보 전환  
$(function() {
	const firstHeight = $(window).height();
	$('.tab-area').on(
			'click',
			'.tab-btns li',
			function(e) {
				var idx = $(this).index();
				$(this).closest('.tab-area').find('.tab-btns').find('li')
						.removeClass('active');
				$(this).addClass('active');
				$(this).closest('.tab-area').find('.tab-box').removeClass(
						'active').eq(idx).addClass('active');
				$(window).height(firstHeight);
				return false;
			});
})

function fnMove(seq) {
	var offset = $("." + seq).offset();
	$('html, body').stop().animate({
		scrollTop : offset.top - 157
	}, 600);
	return false;
}
$(window).on('scroll', function() {
	$('.section').each(function() {
		if ($(window).scrollTop() >= $(this).offset().top - 159) {
			var id = $(this).attr('id');
			$('.tabs ul li a').removeClass('sel');
			$('.tabs ul li a[href=#' + id + ']').addClass('sel');
		}
	});
});
// 메뉴가먼저 열려있게끔하는 이벤트
$(function() {
	$(document).ready(function() {
		$('.review .list li .img img').click(function() {
			$('#Image').addClass("on");
			$('html').css('overflow', 'hidden');
		});
		$('#Image .close, #Image .bg').click(function() {
			$('#Image').removeClass("on");
			$('html').css('overflow', 'auto');
		});
	});
	$('.review .list li .img  img').click(function() {
		var imgPath = $(this).attr("src");
		$("#Image .img img").attr({
			src : imgPath
		});
		return false;

	});
});




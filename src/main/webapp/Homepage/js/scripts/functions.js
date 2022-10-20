	(function($) {
		"use strict";
	
	
	$(document).ready(function() {

	
	
	/*mega menu custon function*/
	$('.dropdown-submenu').hover(function() {
	if ($(window).width() >= 479) {
	var p = $(this);
	var offset = p.offset();
	
	var multiLeft = offset.left;
	var multilevelWidth = $(".multilevel").width();
	var sublevelWidth = $(this).find(".dropdown-menu").width();
	
	var allWidth = multiLeft + multilevelWidth + sublevelWidth;
	
	if ($(window).width() <= allWidth) {
	$(this).find(".dropdown-menu").css("marginLeft", "-" + (multilevelWidth + sublevelWidth) + "px");
	} else {
	$(".dropdown-submenu>.dropdown-menu").css("marginLeft", " ");
	}
	} else {
	$(".dropdown-submenu>.dropdown-menu").css("marginLeft", " ");
	}
	});
	

	/*scroll to top*/
	$(window).scroll(function() {
	if ($(this).scrollTop() > 100) {
	$('.scrollup').fadeIn();
	} else {
	$('.scrollup').fadeOut();
	}
	});
	
	$('.scrollup').on("click",function() {
	$("html, body").animate({
	scrollTop: 0
	}, 500);
	return false;
	
	});
	
	
	/*menu sticky background*/
	$(window).load(function(){
      $("#header, #header2, #header3, #header4, #header5, #header6, #header7, #header8, #header9, #header10").sticky({ topSpacing: 0 });
    }); 
	
	
			});
	
	})(jQuery);
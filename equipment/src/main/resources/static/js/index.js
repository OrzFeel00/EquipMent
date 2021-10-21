$(function(){
    pageBox();
    index();

    if( $('.backLazys').length > 0 ) {
        $(".backLazys").lazyload({effect: "fadeIn",threshold:0});
    }

})
$(window).resize(function(){
    pageBox();
    resizes();
})
$(window).load(function() {
    resizes();
    var wow = new WOW({
        boxClass: 'wow',
        animateClass: 'animated',
        offset: 100,
        mobile: false,
        live: true
    });
    wow.init(); 
})

function index(){

     $('.menu').on('click',function(){
        $('.slide_nav').addClass('left_active')
    })
    $('.phone_back').on('click',function(){
        $('.slide_nav').removeClass('left_active')
    })

    $('.slideJA').on('click',function(){
        var dataChck = $(this).attr('data-check');
        var slideNavSecon=$(this).next('.slideNavSecon');
        var slideNavSeconAL=slideNavSecon.find('a').length;
        if(slideNavSeconAL>0){
            if(dataChck=='yes'){
                slideNavSecon.slideDown();
                $(this).parents('li').siblings('li').find('.slideNavSecon').slideUp();
                $(this).attr('data-check','no');
                $(this).parents('li').siblings('li').find('.slideJA').attr('data-check','yes');
                return false;
            }
        }
    })

    $('.index_menu').on('click',function(){
        $('.nav').toggleClass('active');
    })

    $(document).on('click',function(){
        $('.link_left_select ul').slideUp();
    })
    $('.link_left_botom').on('click',function(e){
        $('.link_left_select ul').slideToggle();
        e.stopPropagation();
    })

     jQuery(".search_icon").click(function(){
        jQuery(".slider-search").animate({top:0,"opacity":"show"},600);
    });
    jQuery(".btnclosess").click(function(){
        jQuery(".slider-search").animate({top:"-100%","opacity":"hide"},600);
    });

    /*头部导航*/
      var navactiveIndex=$('.nav').find('a.active').index('.nav a');
      navMove(navactiveIndex)
      $('.nav a').hover(function(){
          var $index=$(this).index()
          navMove($index,"hover")
      },function(){
          
      })
      $(".navF").hover(function() {
      },function() {
        navMove(navactiveIndex)
      })
       /*头部导航*/

}


function navMove(obj,hover){
    var $this=$('.nav a').eq(obj)
    var $this_span=$this.find('span');
    var $this_spanW=$this.find('span').width();
    var thisLeft=$this_span.offset().left;
    if($(".secguideS li").eq(obj).find("a").length > 0) {
        $('.secguideS li').eq(obj).show().css({'left':thisLeft-40}).stop().animate({'left':thisLeft,opacity:1},400).siblings("li").hide();
        if(hover == "hover") {
           $(".secguideS").stop().animate({'height':40}) 
       } else {
          $(".secguideS").stop().animate({'height':0})  
       }
    } else {
        $(".secguideS").stop().animate({'height':0})
    }
    $('.nav_line').stop().animate({'left':thisLeft+'px','width':$this_spanW+'px'});
}

function resizes(){
    winH = $(window).height();
    winW = $(window).width();
    $('http://www.jabpark.com/skins/demo/js/.popCon .item').height(winH);

    var navactiveIndex=$('.nav').find('a.active').index('.nav a');
    navMove(navactiveIndex)
}

function pageBox() {
    w_width = jQuery(window).width();
    w_height = jQuery(window).height();

    //设置移动端参数
    if (w_width <= 1024) {
        isMobile = true;
    } else if (w_width > 1024) {
        isMobile = false;
    };
    //区分手机端和平板
    if (w_width <= 640) {
        mobile = true;
    } else if (w_width > 640) {
        mobile = false;
    };

}

function imgfadeIn(obj){
    var obj=obj
    var imgL=obj.find('.backLazys').length;
    setTimeout(function(){
        obj.find('.backLazys').each(function(){
            var imgori=$(this).attr('data-original')
            $(this).css({'background-image':'url('+imgori+')'})
        })
    },100)
}

function move (o) {
    var $owlpagination=o.find('.owl-pagination .active').index();
    var obj = o.find('.item').eq($owlpagination);
    o.find('.owl-item').eq($owlpagination).addClass('active').siblings().removeClass('active');
    $('.bossThemeOwl_page a').eq($owlpagination).addClass('active').siblings().removeClass('active');
    $('.index_part1_nav a').eq($owlpagination).addClass('active').siblings().removeClass('active');
    imgfadeIn(obj);
}


function imgClick(){
    $('.video_popup .video_con').animate({top:'-30%',opacity:0},700,function(){
        $box1.remove()
    })
} 

$(function(){
    $('.index_video_bd').on('click',function(){
        $(".video_popup").remove();
        var datavideo=$(this).find('.video_source').val();
        video_src=datavideo;
        $box1 = getVideoDiv(video_src);
        $('body').append($box1);
        $('.video_popup').animate({top:'0%',opacity:1},700)
    })
    function getVideoDiv(video_src){
    $box1 = $([
            '<div class="video_popup">',
                '<div class="video_con">',
                    '<iframe height="100%" width="100%" class="video tran" src="'+video_src+'" frameborder=0 "allowfullscreen"></iframe>',
                '</div>',
                '<div class="video_close tran" onclick="imgClick();"></div>',
            '</div>'
        ].join(''));
        return $box1;
    }
})







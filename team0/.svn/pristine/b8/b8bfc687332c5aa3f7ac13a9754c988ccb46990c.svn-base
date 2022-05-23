/**
 * 
 */
//console.log("Cart Module")
var cartService = (function() {

    var getList = function(callback, error, before, after) {
        //console.log("getCartList()..");

        $.ajax({
            url: "/cart/id",
            type: "get",
			dataType: "json",
			beforeSend : function() {
				if(before) {
					before();
				}
			},
            success: function(result, status, xhr) {
                if(callback){
                	callback(result);
                }
                if(after) {
                	after(result);
                }
            },
            error: function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }
    
    var add = function(cart, callback, error){
        console.log("cartAdd()...");
        $.ajax({
            url:"/cart/add",
            type:"post",
            data:JSON.stringify(cart),
            dataType:"json",
            contentType:"application/json; charset=utf-8",
            success : function(result, status, xhr) {
                if(callback) callback(result);
            },
            error :  function(xhr,status,er){
                if(error) error(er);
            }
        })
    }
    
    var get = function(cno, callback, error) {
        //console.log("get()...");
        $.ajax({
            url:'/cart/get/' + cno ,
            type:"get",
            dataType:"json",
            success : function(result, status, xhr) {
                if(callback) callback(result);
            },
            error :  function(xhr,status,er){
                if(error) error(er);
            }
        })
    }
    
    var remove = function (cno, callback, error) {
        console.log("remove()...");
        
        $.ajax({
            url:'/cart/remove/' + cno,
            type:"delete",
            contentType:"application/json; charset=utf-8",
            success : function(result, status, xhr) {
                if(callback) callback(result);
            },
            error :  function(xhr,status,er){
                if(error) error(xhr);
            }
        })
    }
    
    var plus = function (cno, callback, error) {
    	console.log("plus()...");
    	
    	$.ajax({
    		url:'/cart/plus/' + cno,
    		type:"post",
    		contentType:"application/json; charset=utf-8",
    		success : function(result, status, xhr) {
    			if(callback) callback(result);
    		},
    		error :  function(xhr,status,er){
    			if(error) error(xhr);
    		}
    	})
    }
    
    var minus = function (cno, callback, error) {
    	console.log("minus()...");
    	
    	$.ajax({
    		url:'/cart/minus/' + cno,
    		type:"post",
    		contentType:"application/json; charset=utf-8",
    		success : function(result, status, xhr) {
    			if(callback) callback(result);
    		},
    		error :  function(xhr,status,er){
    			if(error) error(xhr);
    		}
    	})
    }
    
    return {
        getList: getList,
        add:add,
        get:get,
        remove:remove,
        plus:plus,
        minus:minus
    };
})();
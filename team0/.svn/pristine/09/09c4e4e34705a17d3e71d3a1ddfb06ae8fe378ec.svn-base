/**
 * 
 */
var scrollService = (function() {

    var getMenuList = function(param, callback, error, before, after) {
        var sno = param.sno;
        var lastNo = param.lastNo || 0;
        var amount = param.amount || 10;

        var url = "/store/menu/" + sno + "/" + lastNo + "/" + amount;

        $.ajax({
            url: url,
            type: "get",
			dataType:"json",
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
    
    var getStoreList = function(param, callback, error, before, after) {
    	var category = param.category;
    	var lastNo = param.lastNo || 0;
    	var amount = param.amount || 10;
    	var condition = param.condition || "A";
    	var search = param.search || " ";
    	
    	var url = "/store/pages/" + category + "/" + lastNo + "/" + amount + "/" + condition + "/" + search;
    	
    	$.ajax({
    		url: url,
    		type: "get",
    		dataType:"json",
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

    
    var getCartList = function(param, callback, error, before, after) {
    	var sno = param.sno;
    	
    	var url = "/store/pages/" + category + "/" + lastNo + "/" + amount;
    	
    	$.ajax({
    		url: url,
    		type: "get",
    		dataType:"json",
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

    
    return {
        getMenuList: getMenuList, 
        getStoreList: getStoreList,
        getCartList: getCartList
    };
})();
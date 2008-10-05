/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
var web = '/sms';
Ext.onReady(function(){
    Ext.QuickTips.init();

    // Menus can be prebuilt and passed by reference
    var dateMenu = new Ext.menu.DateMenu({
        handler : function(dp, date){
            Ext.example.msg('Date Selected', 'You chose {0}.', date.format('M j, Y'));
        }
    });

    var colorMenu = new Ext.menu.ColorMenu({
        handler : function(cm, color){
            Ext.example.msg('Color Selected', 'You chose {0}.', color);
        }
    });

    var menu = new Ext.menu.Menu({
        id: 'mainMenu',
        items: [{
                text: '會員登錄',
                //checked: true,       // when checked has a boolean value, it is assumed to be a CheckItem
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=createVipUser'}
                //onItemClick//onItemCheck
            },{
                text: '會員查詢',
                handler: function onItemClick(){document.location='http://www.pchome.com.tw'}
            },{
                text: 'Ext for jQuery',
                checked: true,
                checkHandler: onItemCheck
            },
            {
                text: 'I donated!',
                checked:false,
                checkHandler: onItemCheck
            }, '-', {
                text: 'Radio Options',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                        '<b class="menu-title">Choose a Theme</b>',
                        {
                            text: 'Aero Glass',
                            checked: true,
                            group: 'theme',
                            checkHandler: onItemCheck
                        }, {
                            text: 'Vista Black',
                            checked: false,
                            group: 'theme',
                            checkHandler: onItemCheck
                        }, {
                            text: 'Gray Theme',
                            checked: false,
                            group: 'theme',
                            checkHandler: onItemCheck
                        }, {
                            text: 'Default Theme',
                            checked: false,
                            group: 'theme',
                            checkHandler: onItemCheck
                        }
                    ]
                }
            },{
                text: 'Choose a Date',
                iconCls: 'calendar',
                menu: dateMenu // <-- submenu by reference
            },{
                text: 'Choose a Color',
                menu: colorMenu // <-- submenu by reference
            }
        ]
    });

    var tb = new Ext.Toolbar();
    tb.render('toolbar');

    tb.add(
    	{
    		text: '首頁', 
    		iconCls: 'icon-home-small',  // <-- icon
    		handler: onItemClick},'-',
    	{
            text:'會員管理',
            iconCls: 'icon-vip-small',  // <-- icon
            tooltip: {text:'會員相關資料建檔與維護', title:'功能：', autoHide:true},
            menu: 
           	new Ext.menu.Menu({
	        id: 'prdManageMenu',
	        items: [{
	            text: '會員登錄',
	            tooltip: {text:'會員資料建檔與維護', title:'功能：', autoHide:true},
	            handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=createVipUser'},
	            iconCls:'icon-vip'
			},{
			    text: '會員查詢',
			    handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=queryVipUser'},
			    iconCls:'icon-search-vip'
			},{
			    text: '會員標籤列表',
			    handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=configureTagFormat'},
			    iconCls:'icon-search-vip'
			}]})
        }, '-',
        {
        	 text:'產品管理',
            iconCls: 'icon-clothes-small',  // <-- icon
            tooltip: {text:'產品相關資料建檔與維護', title:'功能：', autoHide:true},
            menu:
           	new Ext.menu.Menu({
	        id: 'prdManageMenu',
	        items: [{
                text: '產品類別登錄',
                iconCls:'icon-search-clothes',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=createProductGroup&actionType=CREATE'}
            },{
                text: '產品類別查詢',
                iconCls:'icon-search-clothes',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=queryProductGroup'}
            },{
                text: '產品登錄',
				iconCls:'icon-clothes',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=createProduct'}
            },{
                text: '產品查詢',
                iconCls:'icon-search-clothes',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=queryProduct'}
            }]})
        },'-',
        {
        	 text:'銷售管理',
            iconCls: 'icon-order-small',  // <-- icon
            tooltip: {text:'銷售相關資料建檔與維護', title:'功能：', autoHide:true},
            menu:
           	new Ext.menu.Menu({
	        id: 'prdManageMenu',
	        items: [{
                text: '銷售資料登錄',
                iconCls:'icon-order',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=createOrder'}
            },{
                text: '銷售資料查詢',
                iconCls:'icon-clothes',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=manager&page=queryOrder'}
            }]})
        },'-',
        {
        	text:'簡訊管理',
            iconCls: 'icon-sms-small',  // <-- icon
            tooltip: {text:'簡訊相關資料建檔與維護', title:'功能：', autoHide:true},
            menu:
           	new Ext.menu.Menu({
	        id: 'prdManageMenu',
	        items: [{
                text: '單筆簡訊發送設定',
                iconCls:'icon-sms',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=sms&page=singleSmsSender&isDefault=true'}
            },{
                text: '批次簡訊發送設定',
                iconCls:'icon-multi-sms',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=sms&page=batchSmsConfig&isDefault=true'}
            },{
                text: '簡訊記錄查詢',
                iconCls:'icon-search-sms',
                handler: function onItemClick(){document.location=web + '/main.jsp?fo=sms&page=querySmsHistory'}
            }]})
        }
    );
	
	/*
    menu.addSeparator();
    // Menus have a rich api for
    // adding and removing elements dynamically
    var item = menu.add({
        text: 'Dynamically added Item'
    });
    // items support full Observable API
    item.on('click', onItemClick);

    // items can easily be looked up
    menu.add({
        text: 'Disabled Item',
        id: 'disableMe'  // <-- Items can also have an id for easy lookup
        // disabled: true   <-- allowed but for sake of example we use long way below
    });
    // access items by id or index
    menu.items.get('disableMe').disable();
	*/
	
    // They can also be referenced by id in or components
    /*
    tb.add('-', {
        icon: 'list-items.gif', // icons can also be specified inline
        cls: 'x-btn-icon',
        tooltip: '<b>Quick Tips</b><br/>Icon only button with tooltip'
    }, '-');
    */

    // add a combobox to the toolbar
    /*
    var store = new Ext.data.SimpleStore({
        fields: ['abbr', 'state'],
        data : Ext.exampledata.states // from states.js
    });
    var combo = new Ext.form.ComboBox({
        store: store,
        displayField:'state',
        typeAhead: true,
        mode: 'local',
        triggerAction: 'all',
        emptyText:'Select a state...',
        selectOnFocus:true,
        width:135
    });
    tb.addField(combo);
    */

    // functions to display feedback
    function onButtonClick(btn){
        Ext.example.msg('Button Click','You clicked the "{0}" button.', btn.text);
    }

    function onItemClick(item){
        //Ext.example.msg('Menu Click', 'You clicked the "{0}" menu item.', item.text);
        if(item.text == '首頁')
	        document.location = '/sms';
	    else 
	    	document.location = 'http://www.gmail.com';
    }

    function onItemCheck(item, checked){
        Ext.example.msg('Item Check', 'You {1} the "{0}" menu item.', item.text, checked ? 'checked' : 'unchecked');
    }

    function onItemToggle(item, pressed){
        Ext.example.msg('Button Toggled', 'Button "{0}" was toggled to {1}.', item.text, pressed);
    }

});
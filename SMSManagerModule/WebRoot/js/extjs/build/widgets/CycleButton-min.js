/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.CycleButton=Ext.extend(Ext.SplitButton,{getItemText:function(A){if(A&&this.showText===true){var B="";if(this.prependText){B+=this.prependText}B+=A.text;return B}return undefined},setActiveItem:function(C,A){if(C){if(!this.rendered){this.text=this.getItemText(C);this.iconCls=C.iconCls}else{var B=this.getItemText(C);if(B){this.setText(B)}this.setIconClass(C.iconCls)}this.activeItem=C;if(!A){this.fireEvent("change",this,C)}}},getActiveItem:function(){return this.activeItem},initComponent:function(){this.addEvents({"change":true});if(this.changeHandler){this.on("change",this.changeHandler,this.scope||this);delete this.changeHandler}this.itemCount=this.items.length;this.menu={cls:"x-cycle-menu",items:[]};var D;for(var B=0,A=this.itemCount;B<A;B++){var C=this.items[B];C.group=C.group||this.id;C.itemIndex=B;C.checkHandler=this.checkHandler;C.scope=this;C.checked=C.checked||false;this.menu.items.push(C);if(C.checked){D=C}}this.setActiveItem(D,true);Ext.CycleButton.superclass.initComponent.call(this);this.on("click",this.toggleSelected,this)},checkHandler:function(A,B){if(B){this.setActiveItem(A)}},toggleSelected:function(){this.menu.render();var A=this.activeItem?this.activeItem.itemIndex+1:0;if(A>this.itemCount-1){A=0}this.menu.items.itemAt(A).setChecked(true)}});Ext.reg("cycle",Ext.CycleButton);
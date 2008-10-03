/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.Container=Ext.extend(Ext.BoxComponent,{autoDestroy:true,defaultType:"panel",initComponent:function(){Ext.Container.superclass.initComponent.call(this);this.addEvents({"beforeadd":true,"beforeremove":true,"add":true,"remove":true});var A=this.items;if(A){delete this.items;if(A instanceof Array){this.add.apply(this,A)}else{this.add(A)}}},initItems:function(){if(!this.items){this.items=new Ext.util.MixedCollection(false,this.getComponentId);this.getLayout()}},setLayout:function(A){if(this.layout&&this.layout!=A){this.layout.setContainer(null)}this.initItems();this.layout=A;A.setContainer(this)},render:function(){Ext.Container.superclass.render.apply(this,arguments);if(this.layout){if(typeof this.layout=="string"){this.layout=new Ext.Container.LAYOUTS[this.layout.toLowerCase()](this.layoutConfig)}this.setLayout(this.layout);if(this.activeItem!==undefined){var A=this.activeItem;delete this.activeItem;this.layout.setActiveItem(A);return }}if(!this.ownerCt){this.doLayout()}if(this.monitorResize===true){Ext.EventManager.onWindowResize(this.doLayout,this)}},getLayoutTarget:function(){return this.el},getComponentId:function(A){return A.itemId||A.id},add:function(C){if(!this.items){this.initItems()}var B=arguments,A=B.length;if(A>1){for(var D=0;D<A;D++){this.add(B[D])}return }var F=this.lookupComponent(this.applyDefaults(C));var E=this.items.length;if(this.fireEvent("beforeadd",this,F,E)!==false&&this.onBeforeAdd(F)!==false){this.items.add(F);F.ownerCt=this;this.fireEvent("add",this,F,E)}return F},insert:function(D,C){if(!this.items){this.initItems()}var B=arguments,A=B.length;if(A>2){for(var E=A-1;E>=1;--E){this.insert(D,B[E])}return }var F=this.lookupComponent(this.applyDefaults(C));if(F.ownerCt==this&&this.items.indexOf(F)<D){--D}if(this.fireEvent("beforeadd",this,F,D)!==false&&this.onBeforeAdd(F)!==false){this.items.insert(D,F);F.ownerCt=this;this.fireEvent("add",this,F,D)}return F},applyDefaults:function(A){if(this.defaults){if(typeof A=="string"){A=Ext.ComponentMgr.get(A);Ext.apply(A,this.defaults)}else{if(!A.events){Ext.applyIf(A,this.defaults)}else{Ext.apply(A,this.defaults)}}}return A},onBeforeAdd:function(A){if(A.ownerCt){A.ownerCt.remove(A,false)}if(this.hideBorders===true){A.border=(A.border===true)}},remove:function(A,B){var C=this.getComponent(A);if(C&&this.fireEvent("beforeremove",this,C)!==false){this.items.remove(C);delete C.ownerCt;if(B===true||(B!==false&&this.autoDestroy)){C.destroy()}if(this.layout&&this.layout.activeItem==C){delete this.layout.activeItem}this.fireEvent("remove",this,C)}return C},getComponent:function(A){if(typeof A=="object"){return A}return this.items.get(A)},lookupComponent:function(A){if(typeof A=="string"){return Ext.ComponentMgr.get(A)}else{if(!A.events){return this.createComponent(A)}}return A},createComponent:function(A){return Ext.ComponentMgr.create(A,this.defaultType)},doLayout:function(){if(this.rendered&&this.layout){this.layout.layout()}if(this.items){var C=this.items.items;for(var B=0,A=C.length;B<A;B++){var D=C[B];if(D.doLayout){D.doLayout()}}}},getLayout:function(){if(!this.layout){var A=new Ext.layout.ContainerLayout(this.layoutConfig);this.setLayout(A)}return this.layout},onDestroy:function(){if(this.items){var C=this.items.items;for(var B=0,A=C.length;B<A;B++){Ext.destroy(C[B])}}if(this.monitorResize){Ext.EventManager.removeResizeListener(this.doLayout,this)}Ext.Container.superclass.onDestroy.call(this)},bubble:function(C,B,A){var D=this;while(D){if(C.call(B||D,A||D)===false){break}D=D.ownerCt}},cascade:function(F,E,B){if(F.call(E||this,B||this)!==false){if(this.items){var D=this.items.items;for(var C=0,A=D.length;C<A;C++){if(D[C].cascade){D[C].cascade(F,E,B)}}}}},findById:function(C){var A,B=this;this.cascade(function(D){if(B!=D&&D.id===C){A=D;return false}});return A||null},findByType:function(A){return typeof A=="function"?this.findBy(function(B){return B.constructor===A}):this.findBy(function(B){return B.constructor.xtype===A})},find:function(B,A){return this.findBy(function(C){return C[B]===A})},findBy:function(D,C){var A=[],B=this;this.cascade(function(E){if(B!=E&&D.call(C||E,E,B)===true){A.push(E)}});return A}});Ext.Container.LAYOUTS={};Ext.reg("container",Ext.Container);
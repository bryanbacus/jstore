/*
 * Ext JS Library 2.0 Beta 1
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

/**
 * @class Ext.form.FieldSet
 * @extends Ext.Panel
 * Standard container used for grouping form fields.
 * @constructor
 * @param {Object} config Configuration options
 */
Ext.form.FieldSet = Ext.extend(Ext.Panel, {
    /**
     * @cfg {Boolean} checkboxToggle True to render a checkbox into the fieldset frame just in front of the legend
     * (defaults to false).  The fieldset will be expanded or collapsed when the checkbox is toggled.
     */
    /**
     * @cfg {String} checkboxName The name to assign to the fieldset's checkbox if {@link #checkboxToggle} = true
     * (defaults to '[checkbox id]-checkbox').
     */
    /**
     * @cfg {Number} labelWidth The width of labels. This property cascades to child containers.
     */
    /**
     * @cfg {String} itemCls A css class to apply to the x-form-item of fields. This property cascades to child containers.
     */
    /**
     * @cfg {String} baseCls The base CSS class applied to the fieldset (defaults to 'x-fieldset').
     */
    baseCls:'x-fieldset',
    /**
     * @cfg {String} layout The {@link Ext.Container#layout} to use inside the fieldset (defaults to 'form').
     */
    layout: 'form',

    // private
    onRender : function(ct, position){
        if(!this.el){
            this.el = document.createElement('fieldset');
            this.el.appendChild(document.createElement('legend')).className = 'x-fieldset-header';
        }

        Ext.form.FieldSet.superclass.onRender.call(this, ct, position);

        if(this.checkboxToggle){
            var o = typeof this.checkboxToggle == 'object' ?
                    this.checkboxToggle :
                    {tag: 'input', type: 'checkbox', name: this.checkboxName || this.id+'-checkbox'};
            this.checkbox = this.header.insertFirst(o);
            this.checkbox.dom.checked = !this.collapsed;
            this.checkbox.on('click', this.onCheckClick, this);
        }
    },

    // private
    onCollapse : function(doAnim, animArg){
        if(this.checkbox){
            this.checkbox.dom.checked = false;
        }
        this.afterCollapse();

    },

    // private
    onExpand : function(doAnim, animArg){
        if(this.checkbox){
            this.checkbox.dom.checked = true;
        }
        this.afterExpand();
    },

    /* //protected
     * This is function is called by the fieldset's checkbox when it is toggled (only applies when
     * checkboxToggle = true).  This method should never be called externally, but can be
     * overridden to provide custom behavior when the checkbox is toggled if needed.
     */
    onCheckClick : function(){
        this[this.checkbox.dom.checked ? 'expand' : 'collapse']();
    }
});
Ext.reg('fieldset', Ext.form.FieldSet);


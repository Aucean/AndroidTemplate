<?xml version="1.0"?>

<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <@kt.addAllKotlinDependencies />
    <#include "activity_layout_recipe.xml.ftl" />
     
<#if generateKotlin>
    <instantiate from="src/app_package/classes/Fragment.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/fragment/${className}Fragment.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/fragment/${className}Fragment.kt" />
    
    <instantiate from="src/app_package/classes/ViewModel.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/mvvm/viewmodel/${className}ViewModel.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/mvvm/viewmodel/${className}ViewModel.kt"/>
<#else>
    <instantiate from="src/app_package/classes/Fragment.java.ftl"
    to="${escapeXmlAttribute(srcOut)}/fragment/${className}Fragment.java" />     
    <open file="${escapeXmlAttribute(srcOut)}/fragment/${className}Fragment.java" />
    
    <instantiate from="src/app_package/classes/ViewModel.java.ftl"
    to="${escapeXmlAttribute(srcOut)}/mvvm/viewmodel/${className}ViewModel.java" />
    <open file="${escapeXmlAttribute(srcOut)}/mvvm/viewmodel//${className}ViewModel.java"/>
</#if>

    <instantiate from="src/app_package/classes/Provider.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/mvvm/dataprovider/${className}DataProvider.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/mvvm/dataprovider/${className}DataProvider.kt"/>
    
    <instantiate from="src/app_package/classes/Model.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/mvvm/bindingmodel/${className}BindingModel.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/mvvm/bindingmodel/${className}BindingModel.kt"/>

</recipe>

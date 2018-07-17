<?xml version="1.0"?>
<globals>
    <#include "../common/common_globals.xml.ftl" />
    <global id="resOut" value="${resDir}" />
    <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />
    <global id="fragmentOut" value="${srcDir}/${slashedPackageName(packageName)}/fragment" />
    <global id="presenterOut" value="${srcDir}/${slashedPackageName(packageName)}/presenter" />
    <global id="IOut" value="${srcDir}/${slashedPackageName(packageName)}/uiinterface" />
</globals>

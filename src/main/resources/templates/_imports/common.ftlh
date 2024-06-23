
[#ftl]
[#macro totalCount]
    <div class="totalCount">
        [#if osoby.totalElements == 1]
            Celkem nalezen <strong>${osoby.totalElements}</strong> záznam.
        [#elseif osoby.totalElements <= 4]
            Celkem nalezeny <strong>${osoby.totalElements}</strong> záznamy.
        [#else ]
            Celkem nalezeno <strong>${osoby.totalElements}</strong> záznamů.
        [/#if]
    </div>

[/#macro]

[#macro pager]
    <div class="pager">
        [@pagerLink page=0 active=false text="⇤" /]
        [@pagerLink page=osoby.number - 1 active=osoby.first text="←" /]
        [#list (0..!osoby.totalPages) as pageNumber]
            [@pagerLink page=pageNumber active=pageNumber==osoby.number text=pageNumber + 1 /]
        [/#list]
        [@pagerLink page=osoby.number + 1 active=osoby.last text="→" /]
        [@pagerLink page=osoby.totalPages - 1 active=false text="⇥" /]
    </div>
[/#macro]

[#macro pagerLink page text active]
    [#if active]
        <span class="page active">${text}</span>

    [/#if]
[/#macro]
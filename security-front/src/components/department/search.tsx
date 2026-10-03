import * as React from "react";
import {useState} from "react";
import {Department} from "@/components/department/columns";
import {MyTableMeta, SimplePager, TableOperationProps} from "@/common/lib/table/DataTableProperty";
import {PagerResult} from "@/common/lib/protocol/Result";
import {Button} from "@/components/ui/button";
import DepartmentApi from "@/api/auto/department";
import {useTranslations} from "next-intl";
import SearchSelect from "@/common/components/forms/search-select";
import {PaginationState} from "@tanstack/table-core/src/features/RowPagination";
import useNavigating from "@/common/hook/NavigatingHook";
import {Search as SearchIcon} from "lucide-react";


interface DepartmentQuery extends SimplePager {
    name: string;
    frontendName: string;
    chineseName: string;
    status: number;
}

export default function Search({table}: TableOperationProps<Department>) {
    const meta = table.options.meta as MyTableMeta<Department>;
    const errorTranslate = useTranslations("Department.ErrorMessage")
    const pageTranslate = useTranslations("Department")
    const globalTranslate = useTranslations("GlobalForm");
    const setDataState = meta.setData;
    const [DepartmentQuery, setDepartmentQuery] = useState<DepartmentQuery>({} as DepartmentQuery)
    const Navigations = useNavigating();

    if (setDataState == null) {
        return <>setDataState is not defined</>
    }

    const searchHandler = (page?: PaginationState) => {
        if (!page) {
            page = {pageIndex: 0, pageSize: table.getState().pagination.pageSize}
            table.setPagination(page);
        }
        DepartmentQuery.pageNo = page?.pageIndex;
        DepartmentQuery.pageSize = page?.pageSize;
        DepartmentApi.search(DepartmentQuery, errorTranslate, Navigations.redirectToLogin).then(
            (res) => {
                setDataState(res)
            }
        ).catch(() => {
        });
    };
    meta.searchHandler = searchHandler;


    return (<div
            className="admin-search-bar flex flex-wrap items-center gap-3 rounded-lg bg-muted/40 p-3 [&>input]:w-full [&>input]:max-w-none sm:[&>input]:w-56">
            {/*<SearchInput value={User3Query?.chineseName||""}*/}
            {/*propertyName={"chineseName"} pageTranslate={pageTranslate}*/}
            {/*setSearchCondition={setUser3Query}/>*/}
            <label className="min-w-0 w-full sm:w-40 [&_button]:w-full">
                <span className="sr-only">{pageTranslate("status")}</span>
                <SearchSelect propertyName={"status"} pageTranslate={pageTranslate}
                              setSearchCondition={setDepartmentQuery}
                              dictionary={(meta.result.data as PagerResult<Department>).dictionary['status']}/>
            </label>
            <Button onClick={() => searchHandler()} className="w-full gap-2 px-5 sm:w-auto">
                <SearchIcon className="size-4" aria-hidden="true"/>
                {globalTranslate('search')}
            </Button>
        </div>
    );
}

"use client";
import {SubmitHandler, useForm} from "react-hook-form";
import {valibotResolver} from "@hookform/resolvers/valibot";
import crateScheme from "@/schema/department";
import {Button} from "@/components/ui/button";
import {DialogClose, DialogDescription, DialogFooter, DialogHeader, DialogTitle} from "@/components/ui/dialog";
import DepartmentApi from "@/api/auto/department";
import toast from "react-hot-toast";
import * as v from "valibot";
import {useTranslations} from "next-intl";
import {ValidatableInput} from "@/common/components/forms/validatable-input";
import {MyTableMeta, TableOperationProps} from "@/common/lib/table/DataTableProperty";
import {Department} from "@/components/department/columns";
import useNavigating from "@/common/hook/NavigatingHook";
import {PagerResult} from "@/common/lib/protocol/Result";


export default function Page({callbackHandler, table}: TableOperationProps<Department>) {
    const globalTranslate = useTranslations("GlobalForm");
    const errorTranslate = useTranslations("Department.ErrorMessage")
    const pageTranslate = useTranslations("Department")
    const validateTranslate = useTranslations("Department.validate")

    const FormSchema = crateScheme(validateTranslate);
    type FormData = v.InferOutput<typeof FormSchema>;
    const Navigations = useNavigating();
    const meta = table.options.meta as MyTableMeta<Department>;
    const pageResult = (meta.result.data as PagerResult<Department>)


    const onSubmit: SubmitHandler<FormData> = (
        data: FormData,
    ) => {
        DepartmentApi.save(data, errorTranslate, Navigations.redirectToLogin).then(
            () => {
                callbackHandler?.();
                toast.success(globalTranslate("save") + globalTranslate("operation-success"));
            }
        ).catch(() => {
        });
    };

    const {
        register,
        handleSubmit,
        setValue,
        formState: {
            errors,
            isSubmitted
        },
    } = useForm<FormData>({
        //相当于v.parse
        resolver: valibotResolver(
            FormSchema,
            //https://valibot.dev/guides/parse-data/
            {abortEarly: false, lang: "zh-CN"}
        ),
    });


    return (
        <form className="admin-form admin-form-wide" onSubmit={handleSubmit(onSubmit)}>
            <DialogHeader>
                <DialogTitle>{globalTranslate("add")}</DialogTitle>
                <DialogDescription>
                </DialogDescription>
            </DialogHeader>
            <div className="admin-form-fields">
                <ValidatableInput  {...register("id")}
                                   type={"hidden"}
                                   fieldPropertyName={"id"}/>
                <ValidatableInput readonly={false}  {...register("pinyin")}
                                  type={"text"}
                                  isSubmitted={isSubmitted}
                                  pageTranslate={pageTranslate}
                                  errorMessage={errors.pinyin?.message} fieldPropertyName={"pinyin"}/>
                <ValidatableInput readonly={false}  {...register("code")}
                                  type={"text"}
                                  isSubmitted={isSubmitted}
                                  pageTranslate={pageTranslate}
                                  errorMessage={errors.code?.message} fieldPropertyName={"code"}/>
                <ValidatableInput readonly={false}  {...register("name")}
                                  type={"text"}
                                  isSubmitted={isSubmitted}
                                  pageTranslate={pageTranslate}
                                  errorMessage={errors.name?.message} fieldPropertyName={"name"}/>
                <ValidatableInput readonly={false}  {...register("parentId")}
                                  type={"text"}
                                  isSubmitted={isSubmitted}
                                  pageTranslate={pageTranslate}
                                  errorMessage={errors.parentId?.message} fieldPropertyName={"parentId"}/>
                <ValidatableInput readonly={false}  {...register("manager")}
                                  type={"text"}
                                  isSubmitted={isSubmitted}
                                  pageTranslate={pageTranslate}
                                  errorMessage={errors.manager?.message} fieldPropertyName={"manager"}/>
                <ValidatableInput readonly={false}  {...register("telephone")}
                                  type={"text"}
                                  isSubmitted={isSubmitted}
                                  pageTranslate={pageTranslate}
                                  errorMessage={errors.telephone?.message} fieldPropertyName={"telephone"}/>
                <ValidatableInput readonly={false}  {...register("type")}
                                  type={"text"}
                                  isSubmitted={isSubmitted}
                                  pageTranslate={pageTranslate}
                                  errorMessage={errors.type?.message} fieldPropertyName={"type"}/>
                <ValidatableInput readonly={false}  {...register("sort")}
                                  type={"text"}
                                  isSubmitted={isSubmitted}
                                  pageTranslate={pageTranslate}
                                  errorMessage={errors.sort?.message} fieldPropertyName={"sort"}/>
            </div>
            <DialogFooter>
                <DialogClose asChild>
                    <Button variant="outline">{globalTranslate("cancel")}</Button>
                </DialogClose>
                <Button type="submit">{globalTranslate("save")}</Button>
            </DialogFooter>
        </form>
    );
};

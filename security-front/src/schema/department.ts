import * as v from "valibot";

function createSchema(translate: (key: string) => string) {
    const InnerFormSchema = v.object({
        id:
            v.string()
        , pinyin:
            v.pipe(
                v.string(),
                v.nonEmpty(translate("pinyin.empty-message")))

        , code:
            v.pipe(
                v.string(),
                v.nonEmpty(translate("code.empty-message")))

        , name:
            v.pipe(
                v.string(),
                v.nonEmpty(translate("name.empty-message")))

        , parentId:
            v.pipe(
                v.string(),
                v.nonEmpty(translate("parentId.empty-message")))

        , manager:
            v.pipe(
                v.string(),
                v.nonEmpty(translate("manager.empty-message")))

        , telephone:
            v.pipe(
                v.string(),
                v.nonEmpty(translate("telephone.empty-message")))

        , type:
            v.pipe(
                v.string(),
                v.nonEmpty(translate("type.empty-message")))

        , sort:
            v.pipe(
                v.string(),
                v.nonEmpty(translate("sort.empty-message")),
                v.check((val) => {
                    return /^\d+$/.test(val);
                }, translate("sort.check-message")),
                v.transform((input): number | string => {
                    return parseInt(input, 10);
                }))


    });
    //扩展提示
    const FormSchema = InnerFormSchema;
    //type FormData = v.InferOutput<typeof FormSchema>;
    return FormSchema
}

export default createSchema;

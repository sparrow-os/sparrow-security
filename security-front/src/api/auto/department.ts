import Fetcher from "@/common/lib/Fetcher";
import {IDENTITY} from "@/common/lib/protocol/Identity";
import Result from "@/common/lib/protocol/Result";

export default class DepartmentApi {
    public static search(
        query: object,
        translator: (key: string) => string,
        redirectToLogin: () => void
    ): Promise<Result> {
        const body = JSON.stringify(query);
        return Fetcher.post({
            url: "/department/search.json",
            body,
            translator,
            redirectToLogin: redirectToLogin
        });
    }

    public static save(
        params: object,
        translator: (key: string) => string,
        redirectToLogin: () => void
    ): Promise<Result> {
        const body = JSON.stringify(params);
        return Fetcher.post({
            url: "/department/save.json",
            body,
            translator,
            redirectToLogin: redirectToLogin
        });
    }

    public static batchDelete(
        params: IDENTITY[],
        translator: (key: string) => string,
        redirectToLogin: () => void
    ): Promise<Result> {
        const body = JSON.stringify(params);
        return Fetcher.post({
            url: "/department/delete.json",
            body,
            translator,
            redirectToLogin: redirectToLogin
        });
    }

    public static delete(
        id: IDENTITY,
        translator: (key: string) => string,
        redirectToLogin: () => void
    ): Promise<Result> {
        const body = JSON.stringify([id]);
        return Fetcher.post({
            url: "department/delete.json",
            body,
            translator,
            redirectToLogin: redirectToLogin
        });
    }


    public static disable(
        params: IDENTITY[],
        translator: (key: string) => string,
        redirectToLogin: () => void
    ): Promise<Result> {
        const body = JSON.stringify(params);
        return Fetcher.post({
            url: "/department/disable.json",
            body,
            translator,
            redirectToLogin: redirectToLogin
        });
    }

    public static enable(
        params: IDENTITY[],
        translator: (key: string) => string,
        redirectToLogin: () => void
    ): Promise<Result> {
        const body = JSON.stringify(params);
        return Fetcher.post({
            url: "/department/enable.json",
            body,
            translator,
            redirectToLogin: redirectToLogin
        });
    }
}

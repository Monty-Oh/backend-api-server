import {defineConfig} from "vite";

export default defineConfig({
    devServer: {
        proxy: {
            "/api":
                {
                    changeOrigin: true,
                    pathRewrite: {
                        "^/api": ""
                    },
                    target: "http://localhost:3000"
                }
        }
    }
})

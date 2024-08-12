import {useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import {URL_LOGIN_PAGE} from "../../common/constants";

export default function Main() {

    const isLoggedIn = useSelector((state) => state.token.isLoggedIn);
    const navigate = useNavigate();
    useEffect(() => {
        if (!isLoggedIn) navigate(URL_LOGIN_PAGE);
    }, [isLoggedIn, navigate]);

    return (
        <div>
            <p>main page...</p>
        </div>
    )
}
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import "./Navbar.css"; // custom styles
import logo from "../../src/asset/fleeman-logo.svg"; // adjust path if needed

const Navbar = () => {
  const [username, setUsername] = useState(null);
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const storedUsername = sessionStorage.getItem("username");
    const loggedInStatus = sessionStorage.getItem("isLoggedIn") === "true";
    if (storedUsername && loggedInStatus) {
      setUsername(storedUsername);
      setIsLoggedIn(true);
    }
  }, []);

  const handleLogout = () => {
    sessionStorage.clear();
    setUsername(null);
    setIsLoggedIn(false);
    navigate("/login");
  };

  return (
    <nav
      className="navbar navbar-expand-lg sticky-top shadow custom-navbar"
      style={{ zIndex: 9999 }}
    >
      <div className="container-fluid">
        <Link className="navbar-brand d-flex align-items-center text-white fw-bold fs-3" to="/">
          <img src={logo} alt="FleeMan Logo" height="40" className="me-2" />
          FleeMan
        </Link>

        <button
          className="navbar-toggler bg-secondary"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarContent"
        >
          <span className="navbar-toggler-icon" />
        </button>

        <div className="collapse navbar-collapse" id="navbarContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            {[
              { to: "/", label: "Home" },
              { to: "/modify-booking", label: "Modify/Cancel Booking" },
              { to: "/membership", label: "Membership" },
              { to: "/ContactUs", label: "Contact Us" },
              { to: "/customer-care", label: "Customer Care" },
            ].map(({ to, label }) => (
              <li className="nav-item" key={label}>
                <Link className="nav-link" to={to}>
                  <button className="btn nav-btn text-light">{label}</button>
                </Link>
              </li>
            ))}
          </ul>

          <div className="d-flex align-items-center">
            {isLoggedIn ? (
              <>
                <span className="text-light me-3">Welcome, {username}</span>
                <button className="btn btn-outline-light" onClick={handleLogout}>
                  Logout
                </button>
              </>
            ) : (
              <>
                <Link to="/login" className="me-2">
                  <button className="btn btn-outline-warning">User Login</button>
                </Link>
                <Link to="/AdminLogin">
                  <button className="btn btn-outline-info">Staff Login</button>
                </Link>
              </>
            )}
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;

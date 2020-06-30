
const data = [
  {
    id: "gogo",
    icon: "iconsminds-air-balloon-1",
    label: "menu.gogo",
    to: "/app/gogo",
    subs: [
      {
        icon: "simple-icon-paper-plane",
        label: "menu.start",
        to: "/app/gogo/start"
      },   
      {
        icon: "simple-icon-paper-plane",
        label: "menu.scheduler",
        to: "/app/gogo/scheduler"
      },  
      {
        icon: "simple-icon-paper-plane",
        label: "menu.portfolio",
        to: "/app/gogo/portfolio"
      },   
    ]
  },
  {
    id: "secondmenu",
    icon: "iconsminds-three-arrow-fork",
    label: "menu.second-menu",
    to: "/app/second-menu",
    subs: [
      {
        icon: "simple-icon-paper-plane",
        label: "menu.second",
        to: "/app/second-menu/second"
      }, {
        icon: "simple-icon-paper-plane",
        label: "menu.clients",
        to: "/app/second-menu/clients"
      }
    ]
  }
 
];

if(localStorage.getItem("Role") === "ROLE_ADMIN"){
 //window.location.reload(true);
  var adminpath = {
    id: "admin",
    icon: "iconsminds-three-arrow-fork",
    label: "menu.administration",
    to: "/app/admin/",
    subs: [
      {
        icon: "simple-icon-paper-plane",
        label: "menu.administration",
        to: "/app/admin/collaborateurs"
      }
    ]
  }; 
  data.push(adminpath);
}
export default data;
